package com.adyen.android.assignment.domain.repository


import com.adyen.android.assignment.domain.model.DetailResponse
import com.adyen.android.assignment.domain.model.ExploreResponse
import com.adyen.android.assignment.domain.model.Locale
import com.adyen.android.assignment.domain.model.PhotoResponse


interface VenueRepository {

    suspend fun getVenues(ll: String, offset: Int, limit: Int): ExploreResponse

    suspend fun getVenueDetail(id: String): DetailResponse?

    suspend fun getVenuePhoto(id: String): PhotoResponse?

    suspend fun getAllVenuesFromDb(): List<Locale>?

    suspend fun insertVenuesToDb(list: List<Locale>?): List<Long>?
}