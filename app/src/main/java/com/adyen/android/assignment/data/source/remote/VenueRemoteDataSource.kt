package com.adyen.android.assignment.data.source.remote

import com.adyen.android.assignment.domain.model.DetailResponse
import com.adyen.android.assignment.domain.model.ExploreResponse
import com.adyen.android.assignment.domain.model.PhotoResponse

interface VenueRemoteDataSource {

    suspend fun getVenues(ll: String, offset: Int, limit: Int): ExploreResponse

    suspend fun getVenueDetail(id: String): DetailResponse?
    suspend fun getVenuePhoto(id: String): PhotoResponse?
}