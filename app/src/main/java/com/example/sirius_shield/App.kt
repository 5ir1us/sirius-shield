package com.example.sirius_shield

import android.app.Application
import com.example.sirius_shield.di.adModule
import com.example.sirius_shield.di.billingModule
import com.example.sirius_shield.di.networkModule
import com.example.sirius_shield.di.repositoryModule
import com.example.sirius_shield.di.useCaseModule
import com.example.sirius_shield.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                adModule,
                billingModule,
                networkModule,
                repositoryModule,
                useCaseModule,
                viewModule
            )
        }

    }

}