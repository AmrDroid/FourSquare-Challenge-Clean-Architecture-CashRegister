package com.adyen.android.assignment.domain.usecase

import android.util.Log
import com.adyen.android.assignment.domain.base.SingleUseCase
import com.adyen.android.assignment.domain.model.ExploreResponse
import com.adyen.android.assignment.domain.repository.VenueRepository


class GetVenuesUseCase(private val venueRepository: VenueRepository) :
    SingleUseCase<ExploreResponse, String> {

    var offset = 0
    private val limit = 20

    override suspend fun run(params: String?): ExploreResponse? {
        offset += 20
        Log.i("amr amr",offset.toString()+"")
        return params?.let {
            return venueRepository.getVenues(it, offset, limit)

        }
    }

}