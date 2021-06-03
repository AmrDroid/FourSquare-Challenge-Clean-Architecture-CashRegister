package com.adyen.android.assignment.data.source.local

import com.adyen.android.assignment.domain.model.UserLocation

interface UserLocalDataSource {

    suspend fun insertLocation(location: UserLocation?): Long?

    suspend fun loadLocation(): UserLocation?
}