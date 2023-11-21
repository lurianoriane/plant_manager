package com.example.plantmanager.model

import com.example.plantmanager.R

/**
 * @name: name of the plant
 * @place: where the plant is
 * @haveWater: if the plant is watered or not
 */

data class PlantModel(
    val id: Int,
    var name: String = "Planta",
    var place: String,
    var waterHour: Long,
    var water: Boolean = false,
    val image: Int = R.drawable.plant_image
)
