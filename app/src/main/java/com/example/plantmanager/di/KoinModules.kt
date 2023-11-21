package com.example.plantmanager.di

import androidx.room.Room
import com.example.plantmanager.database.PlantManagerDatabase
import com.example.plantmanager.repository.PlantsRepository
import com.example.plantmanager.ui.viewmodels.MyPlantsViewModel
import com.example.plantmanager.ui.viewmodels.NewPlantViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val appModule = module {
    viewModel { MyPlantsViewModel(get()) }
    viewModel { NewPlantViewModel(get()) }
}

val storageModule = module {
    singleOf(::PlantsRepository)
    single {
        Room.databaseBuilder(
            androidContext(),
            PlantManagerDatabase::class.java,
            "plant-manager.db"
        ).build()
    }
    single {
        get<PlantManagerDatabase>().plantDao()
    }
}