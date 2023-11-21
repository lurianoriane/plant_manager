package com.example.plantmanager.database.entities

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.plantmanager.model.PlantModel

@Entity
data class PlantEntity(
    @PrimaryKey val id: Int,
    var name: String,
    var place: String,
    var waterHour: Long,
    var water: Boolean = false,
    val image : Int
) {
    companion object {
        private val plants = mutableStateListOf<PlantModel>()
    }
}