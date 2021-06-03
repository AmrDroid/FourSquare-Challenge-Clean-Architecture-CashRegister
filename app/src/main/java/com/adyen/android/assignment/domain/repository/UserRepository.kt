package com.adyen.android.assignment.domain.repository

import com.adyen.android.assignment.domain.model.UserLocation

interface UserRepository {

    suspend fun insertLocation(location: UserLocation?): Long?

    suspend fun loadUserLocation(): UserLocation?
}