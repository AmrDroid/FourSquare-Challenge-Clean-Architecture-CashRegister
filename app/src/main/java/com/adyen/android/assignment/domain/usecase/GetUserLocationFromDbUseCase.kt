package com.adyen.android.assignment.domain.usecase

import com.adyen.android.assignment.domain.base.SingleUseCase
import com.adyen.android.assignment.domain.model.UserLocation
import com.adyen.android.assignment.domain.repository.UserRepository

class GetUserLocationFromDbUseCase(private val userRepository: UserRepository) :
    SingleUseCase<UserLocation?,Any?> {

    override suspend fun run(params: Any?): UserLocation? {
        return userRepository.loadUserLocation()
    }


}