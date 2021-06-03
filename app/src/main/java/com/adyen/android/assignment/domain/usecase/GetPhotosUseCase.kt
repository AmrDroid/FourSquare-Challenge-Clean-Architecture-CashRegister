package com.adyen.android.assignment.domain.usecase

import com.adyen.android.assignment.domain.base.SingleUseCase
import com.adyen.android.assignment.domain.model.ExploreResponse
import com.adyen.android.assignment.domain.model.PhotoResponse
import com.adyen.android.assignment.domain.repository.VenueRepository

class GetPhotosUseCase(private val venueRepository: VenueRepository) :
    SingleUseCase<PhotoResponse, String> {

    override suspend fun run(params: String?): PhotoResponse? {
        return params?.let { venueRepository.getVenuePhoto(it) }
    }

}