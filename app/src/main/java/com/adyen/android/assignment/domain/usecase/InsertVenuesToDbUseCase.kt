package com.adyen.android.assignment.domain.usecase

import com.adyen.android.assignment.domain.base.SingleUseCase
import com.adyen.android.assignment.domain.model.Locale
import com.adyen.android.assignment.domain.repository.VenueRepository


class InsertVenuesToDbUseCase(private val venueRepository: VenueRepository) :
    SingleUseCase<List<Long>?, List<Locale>?> {

    override suspend fun run(params: List<Locale>?): List<Long>? {
        return venueRepository.insertVenuesToDb(params)
    }

}