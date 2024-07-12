package com.example.plantmanager.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.plantmanager.model.PlantModel
import com.example.plantmanager.repository.PlantsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class PlantUiState(
    val id: Int = 0,
    val name: String = "",
    val place: String = "",
    val waterHour: Long = 0,
    val water: Boolean = false,
    val onHourChanged: (PlantModel) -> Unit = {},
    val onPlaceChanged: (PlantModel) -> Unit = {},
    val onNameChanged: (PlantModel) -> Unit = {}
)

class PlantViewModel(private val repository: PlantsRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<PlantUiState> = MutableStateFlow(PlantUiState())
    val uiState = _uiState.asStateFlow()


    init {
        _uiState.update { currentState ->
            currentState.copy(
                onHourChanged = {
                    _uiState.update {
                        it.copy(waterHour = it.waterHour)
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

    fun updateName(newName: String) {
        _uiState.update {
            it.copy(name = newName)
        }
    }

    fun updatePlace(newPlace: String) {
        _uiState.update {
            it.copy(place = newPlace)
        }
    }
}