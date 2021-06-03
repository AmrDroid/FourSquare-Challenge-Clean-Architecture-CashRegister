package com.adyen.android.assignment.domain.usecase

import com.adyen.android.assignment.domain.base.SingleUseCase
import com.adyen.android.assignment.domain.model.DetailResponse
import com.adyen.android.assignment.domain.repository.VenueRepository

class GetVenueDetailUseCase(private val venueRepository: VenueRepository)
    : SingleUseCase<DetailResponse, String> {

    override suspend fun run(params: String?): DetailResponse? {
        return params?.let { venueRepository.getVenueDetail(it) }
    }

}