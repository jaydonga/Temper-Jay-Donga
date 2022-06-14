package com.temper.jaydonga.common

import android.app.Application
import org.koin.core.context.startKoin

class TemperApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}