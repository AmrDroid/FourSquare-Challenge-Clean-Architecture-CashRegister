package com.adyen.android.assignment
import com.adyen.android.assignment.R
import com.adyen.android.assignment.data.source.remote.base.ApiService
import com.adyen.android.assignment.domain.base.traceErrorException
import com.adyen.android.assignment.domain.model.ApiError
import com.adyen.android.assignment.domain.model.UNKNOWN_ERROR_MESSAGE
import com.google.common.truth.Truth
import okhttp3.Response
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.HttpException
import retrofit2.Response.success
import java.io.IOException
import java.net.SocketTimeoutException

@RunWith(JUnit4::class)
class ExceptionHandlerTest {
    @Test
    fun socket_time_out_exception_then_return_timeout() {
        val throwable = SocketTimeoutException()

        val message = traceErrorException(throwable)
        Truth.assertThat(message)
            .isEqualTo(ApiError(throwable.message, ApiError.ErrorStatus.TIMEOUT))
    }

    @Test
    fun unknown_exception_then_return_timeout() {
        val throwable = Exception()
        val message = traceErrorException(throwable)
        Truth.assertThat(message)
            .isEqualTo(ApiError(UNKNOWN_ERROR_MESSAGE, 0, ApiError.ErrorStatus.UNKNOWN_ERROR))
    }
    @Test
    fun io_exception_then_return_timeout() {
        val throwable = IOException()
        val message = traceErrorException(throwable)
        Truth.assertThat(message)
            .isEqualTo(ApiError(throwable.message, ApiError.ErrorStatus.NO_CONNECTION))
    }

}