package com.example.koinsampleapp

import android.app.Application
import com.example.koinsampleapp.commom.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                AppModule.apiModule,
                AppModule.repositoryModule,
                AppModule.regionModule,
                AppModule.dialectModule
            )
        }
    }
}