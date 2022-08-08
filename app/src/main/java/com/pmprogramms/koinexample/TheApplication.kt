package com.pmprogramms.koinexample

import android.app.Application
import com.pmprogramms.koinexample.modules.apiModule
import com.pmprogramms.koinexample.modules.repositoryModule
import com.pmprogramms.koinexample.modules.retrofitModule
import com.pmprogramms.koinexample.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TheApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@TheApplication)
            modules(listOf(repositoryModule, viewModelModule, retrofitModule, apiModule))
        }
    }
}