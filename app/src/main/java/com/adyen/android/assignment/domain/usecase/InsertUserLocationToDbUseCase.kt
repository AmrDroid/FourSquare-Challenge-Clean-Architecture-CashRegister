package com.adyen.android.assignment.domain.usecase

import com.adyen.android.assignment.domain.base.SingleUseCase
import com.adyen.android.assignment.domain.model.UserLocation
import com.adyen.android.assignment.domain.repository.UserRepository

class InsertUserLocationToDbUseCase(private val userRepository: UserRepository) :
    SingleUseCase<Long?, UserLocation?>{

    override suspend fun run(params: UserLocation?): Long? {
        return userRepository.insertLocation(params)
    }

}