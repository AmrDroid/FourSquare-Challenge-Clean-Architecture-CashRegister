package com.adyen.android.assignment.di

import android.app.Application
import androidx.room.Room
import com.adyen.android.assignment.data.source.local.base.AppDatabase
import com.adyen.android.assignment.data.source.local.base.dao.LocaleDao
import org.koin.dsl.module


val databaseModule = module {

    single { createAppDatabase(get()) }
    single { provideLocaleDao(db = get()) }

}

internal fun createAppDatabase(application: Application): AppDatabase {
    return Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        AppDatabase.DB_NAME
    ).build()
}

internal fun provideLocaleDao(db: AppDatabase): LocaleDao = db.localeDao