package com.brito.pokedex

import android.app.Application
import com.brito.pokedex.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class PokedexApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidContext(applicationContext)
            modules(
                AppModule.api,
                AppModule.repository,
                AppModule.presentation
            )
        }
    }
}