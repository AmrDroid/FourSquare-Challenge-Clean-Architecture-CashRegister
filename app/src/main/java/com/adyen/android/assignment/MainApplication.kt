package com.adyen.android.assignment

import android.app.Application
import androidx.multidex.MultiDex
import com.adyen.android.assignment.di.appModule
import com.adyen.android.assignment.di.databaseModule
import com.adyen.android.assignment.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this) //To avoid build error - for app with over 64k methods

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(appModule, networkModule, databaseModule))
        }
    }
}