package com.adyen.android.assignment.data.source.local.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.adyen.android.assignment.data.source.local.base.AppDatabase.Companion.DB_VERSION
import com.adyen.android.assignment.data.source.local.base.dao.LocaleDao
import com.adyen.android.assignment.data.source.local.base.dao.UserLocationDao
import com.adyen.android.assignment.domain.model.Locale
import com.adyen.android.assignment.domain.model.UserLocation

/**
 * To manage data items that can be accessed and updated
 * & also maintain relationships between them
 *
 * @Created by Amr
 */
@Database(entities = [Locale::class, UserLocation::class], version = DB_VERSION, exportSchema = false)
@TypeConverters(CategoryTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract val localeDao: LocaleDao
    abstract val userLocationDao : UserLocationDao

    companion object {
        const val DB_NAME = "forsquareapp.db"
        const val DB_VERSION = 1
    }
}