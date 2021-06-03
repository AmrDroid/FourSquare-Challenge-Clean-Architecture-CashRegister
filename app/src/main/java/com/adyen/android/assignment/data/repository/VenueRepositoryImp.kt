package com.adyen.android.assignment.data.repository

import com.adyen.android.assignment.data.source.local.VenueLocalDataSource
import com.adyen.android.assignment.data.source.remote.VenueRemoteDataSource
import com.adyen.android.assignment.domain.model.DetailResponse
import com.adyen.android.assignment.domain.model.ExploreResponse
import com.adyen.android.assignment.domain.model.Locale
import com.adyen.android.assignment.domain.model.PhotoResponse
import com.adyen.android.assignment.domain.repository.VenueRepository


/**
 * This class is responsible to choose a source for fetching data
 * Local data will be fetched using [VenueLocalDataSource]
 * and Remote data using [VenueRemoteDataSource]
 *
 * @author Amr
 * */
class VenueRepositoryImp constructor(
    private val venueRemoteDataSource: VenueRemoteDataSource,
    private val venueLocalDataSource: VenueLocalDataSource
) : VenueRepository {

    override suspend fun getVenues(ll: String, offset: Int, limit: Int): ExploreResponse {
        return venueRemoteDataSource.getVenues(ll, offset, limit)
    }

    override suspend fun getVenueDetail(id: String): DetailResponse? {
        return venueRemoteDataSource.getVenueDetail(id)
    }


    override suspend fun getVenuePhoto(id: String): PhotoResponse? {
        return venueRemoteDataSource.getVenuePhoto(id)
    }

    override suspend fun getAllVenuesFromDb(): List<Locale>? {
        return venueLocalDataSource.getAllVenues()
    }

    override suspend fun insertVenuesToDb(list: List<Locale>?): List<Long>?  {
        return venueLocalDataSource.insertAllVenues(list)
    }

}