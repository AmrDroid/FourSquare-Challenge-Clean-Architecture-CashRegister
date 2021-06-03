package com.adyen.android.assignment.viewmodels
import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adyen.android.assignment.fakes.FakeGetVenueDetailUseCase
import com.adyen.android.assignment.presentation.detail.DetailViewModel
import com.adyen.android.assignment.utils.Result
import com.adyen.android.assignment.utils.observeOnce
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
@ExperimentalCoroutinesApi
internal class VenueDetailViewModelTest : BaseViewModelTest() {

    private lateinit var detailViewModel: DetailViewModel

    override fun prepareViewModel(result: Result) {
        val fakeGetVenueDetailUseCase = FakeGetVenueDetailUseCase(result)
         detailViewModel=DetailViewModel(fakeGetVenueDetailUseCase)

    }


    @Test
    fun get_venue_detail_test() {
        coroutineTestRule.dispatcher.runBlockingTest {
            prepareViewModel(Result.SUCCESS)

            detailViewModel.getVenueDetail("412d2800f964a520df0c1fe3")

            detailViewModel.venueDetail.observeOnce { state ->
                Truth.assertThat(state).isNotNull()
            }
        }
    }


}