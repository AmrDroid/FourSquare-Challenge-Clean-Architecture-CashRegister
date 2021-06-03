package com.adyen.android.assignment.data.source.remote

import com.adyen.android.assignment.data.source.remote.base.ApiService
import com.adyen.android.assignment.domain.model.DetailResponse
import com.adyen.android.assignment.domain.model.ExploreResponse
import com.adyen.android.assignment.domain.model.PhotoResponse

class VenueRemoteDataSourceImp(private val apiService: ApiService) : VenueRemoteDataSource {


    override suspend fun getVenues(ll: String, offset: Int, limit: Int): ExploreResponse {
        return apiService.getVenues(ll, offset, limit)
    }

    override suspend fun getVenueDetail(id: String): DetailResponse? {
        return apiService.getVenueDetail(id)
    }

    override suspend fun getVenuePhoto(id: String): PhotoResponse? {
        return apiService.getVenueImage(id)
    }
}