package com.adyen.android.assignment.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.adyen.android.assignment.data.source.local.UserLocalDataSourceImp
import com.adyen.android.assignment.data.source.local.base.AppDatabase
import com.adyen.android.assignment.di.appModule
import com.adyen.android.assignment.di.databaseModule
import com.adyen.android.assignment.di.networkModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import java.io.IOException

open class BaseClient : AutoCloseKoinTest() {

    lateinit var db: AppDatabase

    @Before
    open fun setup() {

        val context = ApplicationProvider.getApplicationContext<Context>()
        startKoin {
            modules(listOf(appModule, networkModule, databaseModule))
        }
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
    }

    @After
    @Throws(IOException::class)
    fun deleteDataBase() {
        runBlocking(Dispatchers.IO) {
            db.clearAllTables()
        }
        db.close()
    }

}