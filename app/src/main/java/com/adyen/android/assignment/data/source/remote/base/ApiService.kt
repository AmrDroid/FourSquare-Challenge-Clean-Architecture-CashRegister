package com.adyen.android.assignment.data.source.remote.base

import com.adyen.android.assignment.domain.model.DetailResponse
import com.adyen.android.assignment.domain.model.ExploreResponse
import com.adyen.android.assignment.domain.model.PhotoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {
    

    @GET("venues/explore")
    suspend fun getVenues(
        @Query("ll") latLong: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("radius") radius: Int=1000
    ): ExploreResponse




    @GET("venues/{id}")
    suspend fun getVenueDetail(
        @Path("id") venueId: String
    ): DetailResponse


    @GET("venues/{id}/photos")
    suspend fun getVenueImage(
        @Path("id") venueId: String
    ): PhotoResponse

}