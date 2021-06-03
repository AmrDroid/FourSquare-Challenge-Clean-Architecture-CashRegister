package com.adyen.android.assignment.data.repository

import com.adyen.android.assignment.data.source.local.UserLocalDataSource
import com.adyen.android.assignment.data.source.remote.UserRemoteDataSource
import com.adyen.android.assignment.domain.model.UserLocation
import com.adyen.android.assignment.domain.repository.UserRepository

/**
 * To choose a source for fetching data relating user such as Location
 * [UserLocalDataSource] for local data
 * [UserRemoteDataSource] for remote data
 *
 * @author Amr
 * */
class UserRepositoryImp constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource
) : UserRepository {

    override suspend fun insertLocation(location: UserLocation?): Long? {
        return userLocalDataSource.insertLocation(location)
    }

    override suspend fun loadUserLocation(): UserLocation? {
        return userLocalDataSource.loadLocation()
    }

}