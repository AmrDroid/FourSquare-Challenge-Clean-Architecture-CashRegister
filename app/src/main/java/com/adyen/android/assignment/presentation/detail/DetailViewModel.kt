package com.adyen.android.assignment.presentation.detail


import androidx.lifecycle.viewModelScope
import com.adyen.android.assignment.domain.base.SingleUseCase
import com.adyen.android.assignment.domain.base.UseCaseResponse
import com.adyen.android.assignment.domain.model.ApiError
import com.adyen.android.assignment.domain.model.DetailResponse
import com.adyen.android.assignment.domain.model.VenueDetail
import com.adyen.android.assignment.domain.usecase.GetVenueDetailUseCase
import com.adyen.android.assignment.presentation.base.BaseViewModel
import com.adyen.android.assignment.presentation.util.SingleLiveEvent


class DetailViewModel(private val getVenueDetailUseCase: SingleUseCase<DetailResponse, String>) : BaseViewModel() {

    private var _venueDetailData = SingleLiveEvent<VenueDetail>()
    val venueDetail = _venueDetailData


    fun getVenueDetail(id: String) {
        showLoading(true)

        getVenueDetailUseCase.invoke(viewModelScope, id, object : UseCaseResponse<DetailResponse> {
            override fun onSuccess(result: DetailResponse?) {

                showLoading(false)
                _venueDetailData.value = result?.response?.venue
            }

            override fun onError(error: ApiError) {
                showLoading(false)
                handleError(error)
            }
        })
    }
}