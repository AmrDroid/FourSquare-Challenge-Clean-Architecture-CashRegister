package com.adyen.android.assignment.viewmodels

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adyen.android.assignment.domain.model.ExploreResponse
import com.adyen.android.assignment.fakes.FakeGetVenuesUseCase
import com.adyen.android.assignment.presentation.venues.VenuesViewModel
import com.adyen.android.assignment.utils.Data.exploreResponse
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import com.adyen.android.assignment.utils.Result
import com.adyen.android.assignment.utils.observeOnce


@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
@ExperimentalCoroutinesApi
class VenuesViewModelTest : BaseViewModelTest() {

    private lateinit var venuesViewModel: VenuesViewModel

    override fun prepareViewModel(result: Result) {
        val fakeGetVenuesUseCase = FakeGetVenuesUseCase(result)
        venuesViewModel = VenuesViewModel(fakeGetVenuesUseCase,null,null,null,null,null)
    }


    @Test
    fun get_venues_success_state() {
        coroutineTestRule.dispatcher.runBlockingTest {
            prepareViewModel(Result.SUCCESS)
            venuesViewModel.fetchVenues("40.74224,-73.99386")

            advanceTimeBy(500)

            venuesViewModel.venues.observeOnce { state ->
                Truth.assertThat(state).isEqualTo(exploreResponse)
            }

        }
    }
    @Test
    fun get_venues_empty_state() {
        coroutineTestRule.dispatcher.runBlockingTest {
            prepareViewModel(Result.SUCCESS)
            venuesViewModel.fetchVenues("")
            advanceTimeBy(500)
            venuesViewModel.venues.observeOnce { state ->
                Truth.assertThat(state).isEqualTo(ExploreResponse(null,null))
            }

        }
    }

}