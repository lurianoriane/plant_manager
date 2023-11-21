package com.example.plantmanager.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantmanager.model.PlantModel
import com.example.plantmanager.repository.PlantsRepository
import com.example.plantmanager.repository.toPlantModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class MyPlantsUiState(
    val plants: List<PlantModel> = emptyList(),
    val onPlantWaterTrue: (PlantModel) -> Unit = {},
    val onHourChanged : (PlantModel) -> Unit = {}
)

class MyPlantsViewModel(private val repository: PlantsRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<MyPlantsUiState> = MutableStateFlow(MyPlantsUiState())

    val uiState
        get() = _uiState
            .combine(repository.plants) { uiState, plants ->
                uiState.copy(plants = plants.map { it.toPlantModel() })
            }

    init {
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(onPlantWaterTrue = { plantModel ->
                    viewModelScope.launch {
                        repository.toggleWaterTrue(plantModel)
                    }
                })
            }
        }
    }

    private val _plants =
        MutableStateFlow<PlantModel>(PlantModel(id = 1, name = "planta", place = "sala", waterHour = 123, water = false))
    val plants = _plants.asStateFlow()

}