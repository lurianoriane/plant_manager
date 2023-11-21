package com.example.plantmanager.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.plantmanager.database.dao.PlantDao
import com.example.plantmanager.database.entities.PlantEntity

@Database(entities = [PlantEntity::class], version = 1)
abstract class PlantManagerDatabase : RoomDatabase() {

    abstract fun plantDao(): PlantDao
}