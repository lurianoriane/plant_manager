package com.example.plantmanager

import android.app.Application
import com.example.plantmanager.di.appModule
import com.example.plantmanager.di.storageModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PlantManagerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@PlantManagerApplication)
            modules(appModule, storageModule)
        }
    }
}