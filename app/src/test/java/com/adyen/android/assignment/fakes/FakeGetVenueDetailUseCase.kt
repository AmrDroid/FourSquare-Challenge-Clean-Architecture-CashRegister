package com.adyen.android.assignment.fakes

import com.adyen.android.assignment.domain.base.SingleUseCase
import com.adyen.android.assignment.domain.model.DetailResponse
import com.adyen.android.assignment.utils.Data.detailsResponse
import com.adyen.android.assignment.utils.Result
class FakeGetVenueDetailUseCase(result: Result) :
    BaseTestUseCase<DetailResponse, String>(result),SingleUseCase<DetailResponse, String> {

    override suspend fun run(params: String?): DetailResponse? {
        return if (!params.isNullOrEmpty()) detailsResponse else DetailResponse(null, null)
    }

    override fun getValue(params: String): DetailResponse = detailsResponse


}
