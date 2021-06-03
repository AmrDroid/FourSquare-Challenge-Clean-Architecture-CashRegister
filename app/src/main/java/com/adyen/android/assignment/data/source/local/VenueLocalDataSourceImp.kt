package com.adyen.android.assignment.data.source.local

import com.adyen.android.assignment.data.source.local.base.AppDatabase
import com.adyen.android.assignment.domain.model.Locale

class VenueLocalDataSourceImp(private val appDatabase: AppDatabase) : VenueLocalDataSource {

    override suspend fun getAllVenues(): List<Locale>? {
        return appDatabase.localeDao.loadAll()
    }

    override suspend fun insertAllVenues(list : List<Locale>?) : List<Long>? {
        return appDatabase.localeDao.deleteAllThenInsertNewLocales(list)
    }
}