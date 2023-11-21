package com.example.plantmanager.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.plantmanager.model.PlantModel
import com.example.plantmanager.repository.PlantsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class PlantUiState(
    val id: Int = 0,
    var name: String = "",
    var place: String = "",
    var waterHour: Long = 0,
    val water: Boolean = false,
    val onHourChanged: (PlantModel) -> Unit = {},
    var onPlaceChanged: (PlantModel) -> Unit = {},
    var onNameChanged: (PlantModel) -> Unit = {}

)

class NewPlantViewModel(private val repository: PlantsRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<PlantUiState> = MutableStateFlow(PlantUiState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onHourChanged = { waterHour ->
                    _uiState.update {
                        it.copy(waterHour = waterHour.waterHour)
                    }
                },
                onNameChanged = {
                    _uiState.update {
                        it.copy(name = it.name)
                    }
                },
                onPlaceChanged = {
                    _uiState.update {
                        it.copy(place = it.place)
                    }
                }
            )
        }
    }

    suspend fun save() {
        with(_uiState.value) {
            repository.save(PlantModel(id = id, name = name, place = place, waterHour = waterHour, water = water))
        }
    }
}