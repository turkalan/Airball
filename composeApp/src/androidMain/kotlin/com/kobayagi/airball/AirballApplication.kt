package com.kobayagi.airball

import android.app.Application
import org.koin.android.ext.koin.androidContext

class AirballApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@AirballApplication)
        }
    }
}