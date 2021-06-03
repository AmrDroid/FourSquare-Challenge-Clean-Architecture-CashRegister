package com.adyen.android.assignment.data.local

import android.content.Context
import android.os.Build
import com.adyen.android.assignment.data.local.BaseClient
import com.adyen.android.assignment.data.source.local.VenueLocalDataSource
import com.adyen.android.assignment.data.source.local.VenueLocalDataSourceImp
import com.google.common.truth.Truth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.IOException

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class VenueLocalDataSourceTest : BaseClient() {

    private lateinit var localDataSource: VenueLocalDataSource

    @Before
    open fun setup2() {
        localDataSource = VenueLocalDataSourceImp(db)
    }

    @Test
    fun save_get_all_venues_test() {
        runBlocking(Dispatchers.IO) {

            localDataSource.insertAllVenues(listOf(Data.locale1, Data.locale2))
            val venues = localDataSource.getAllVenues()
            Truth.assertThat(venues).isEqualTo(listOf(Data.locale1, Data.locale2))
        }
    }

}
