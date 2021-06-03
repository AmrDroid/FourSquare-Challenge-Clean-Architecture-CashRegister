package com.adyen.android.assignment.data.remote.repository
import com.adyen.android.assignment.data.remote.BaseClient
import com.adyen.android.assignment.data.source.remote.VenueRemoteDataSource
import com.adyen.android.assignment.data.source.remote.VenueRemoteDataSourceImp
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class DetailsRepositoryClient : BaseClient() {

    private lateinit var venueRemoteDataSource: VenueRemoteDataSource

    @Before
    override fun setup() {
        super.setup()
        venueRemoteDataSource = VenueRemoteDataSourceImp(apiService)
    }

    @Test
    fun get_venues_test() {
        runBlocking {
            val venues = venueRemoteDataSource.getVenues("40.74224,-73.99386", 10, 10)

            Truth.assertThat(venues.response?.groups?.get(0)?.items?.size).isAtLeast(1)
            Truth.assertThat(venues).isNotNull()

        }
    }


    @Test
    fun get_venue_detail_test() {
        runBlocking {
            val venueDetail = venueRemoteDataSource.getVenueDetail("5a0e475b018cbb6a2196479e")
            Truth.assertThat(venueDetail).isNotNull()

        }
    }

    @Test
    fun no_venues_test() {
        runBlocking {
            val venues = venueRemoteDataSource.getVenues("40.74224,-73.99386", 5, 5)
            Truth.assertThat(venues.response?.groups?.size).isNull()
        }
    }

}
