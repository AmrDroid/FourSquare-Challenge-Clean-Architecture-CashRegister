package com.adyen.android.assignment.fakes

import com.adyen.android.assignment.domain.base.SingleUseCase
import com.adyen.android.assignment.domain.model.ExploreResponse
import com.adyen.android.assignment.domain.model.Locale
import com.adyen.android.assignment.utils.Data.exploreResponse
import com.adyen.android.assignment.utils.Result


class FakeGetVenuesUseCase(
    result: Result
) : BaseTestUseCase<ExploreResponse, String>(result), SingleUseCase<ExploreResponse, String> {


    override fun getValue(params: String): ExploreResponse {
        return if (params.contentEquals("40.74224,-73.99386")) exploreResponse
        else ExploreResponse(null,null)
    }

    override suspend fun run(params: String?): ExploreResponse = exploreResponse

}