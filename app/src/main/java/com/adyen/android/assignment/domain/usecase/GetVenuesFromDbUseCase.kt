package com.adyen.android.assignment.domain.usecase

import com.adyen.android.assignment.domain.base.SingleUseCase
import com.adyen.android.assignment.domain.model.Locale
import com.adyen.android.assignment.domain.repository.VenueRepository

class GetVenuesFromDbUseCase(private val venueRepository: VenueRepository) :
    SingleUseCase<List<Locale>?, Any?>{

    override suspend fun run(params: Any?): List<Locale>? {
        return venueRepository.getAllVenuesFromDb()
    }

}