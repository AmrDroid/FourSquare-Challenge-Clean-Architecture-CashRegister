package com.adyen.android.assignment.data.source.local

import com.adyen.android.assignment.data.source.local.base.AppDatabase
import com.adyen.android.assignment.domain.model.UserLocation

class UserLocalDataSourceImp(private val appDatabase: AppDatabase) : UserLocalDataSource {

    override suspend fun insertLocation(location: UserLocation?): Long? {
        return appDatabase.userLocationDao.insert(location)
    }

    override suspend fun loadLocation(): UserLocation? {
        return appDatabase.userLocationDao.load()
    }
}