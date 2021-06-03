package com.adyen.android.assignment.domain.base

import com.adyen.android.assignment.domain.model.ApiError

interface UseCaseResponse<Type> {

    fun onSuccess(result: Type?)

    fun onError(error: ApiError)
}