package com.adyen.android.assignment.data.remote.helpers

import com.adyen.android.assignment.data.remote.ApiConstants.NO_Venues_URI
import com.adyen.android.assignment.data.remote.ApiConstants.Venues_Detail_URI
import com.adyen.android.assignment.data.remote.ApiConstants.Venues_URI
import com.adyen.android.assignment.data.remote.NO_SEARCH_RESULT
import com.adyen.android.assignment.data.remote.VENUES_Detail_RESULT
import com.adyen.android.assignment.data.remote.VENUES_SEARCH_RESULT
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection


internal class ApiRequestDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {

            Venues_URI -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(VENUES_SEARCH_RESULT)
            }
            Venues_Detail_URI -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(VENUES_Detail_RESULT)
            }

            NO_Venues_URI -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(NO_SEARCH_RESULT)
            }

            else -> throw IllegalArgumentException("Unknown Request Path ${request.path.toString()}")
        }
    }

}