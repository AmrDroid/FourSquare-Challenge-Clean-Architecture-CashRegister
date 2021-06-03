package com.adyen.android.assignment.data.local
import android.os.Build
import com.adyen.android.assignment.data.source.local.UserLocalDataSource
import com.adyen.android.assignment.data.source.local.UserLocalDataSourceImp
import com.adyen.android.assignment.domain.model.UserLocation
import com.google.common.truth.Truth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class UserLocalDataSourceTest : BaseClient() {

    private lateinit var localDataSource: UserLocalDataSource

    @Before
    open fun setup2() {
        localDataSource = UserLocalDataSourceImp(db)
    }

    @Test
    fun save_get_location_test() {
        runBlocking(Dispatchers.IO) {

            localDataSource.insertLocation(UserLocation(latitude = "14.47",longitude = "15.412"))
            val venues = localDataSource.loadLocation()
            Truth.assertThat(venues).isNotNull()
        }
    }




}
