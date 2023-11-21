package com.example.plantmanager.repository

import com.example.plantmanager.database.dao.PlantDao
import com.example.plantmanager.database.entities.PlantEntity
import com.example.plantmanager.model.PlantModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class PlantsRepository(private val dao: PlantDao) {

    val plants get() = dao.findAll()

    suspend fun save(plant: PlantModel) = withContext(IO) {
        dao.save(plant.toPlantEntity())
    }

    suspend fun toggleWaterTrue(plant: PlantModel) = withContext(IO) {
        val entity = plant.copy(water = !plant.water)
            .toPlantEntity()
        dao.save(entity)
    }
}

fun PlantModel.toPlantEntity() = PlantEntity(
    id = this.id,
    name = this.name,
    place = this.place,
    waterHour = this.waterHour,
    water = this.water,
    image = this.image
)

fun PlantEntity.toPlantModel() = PlantModel(
    id = this.id,
    name = this.name,
    place = this.place,
    waterHour = this.waterHour,
    water = this.water,
    image = this.image
)