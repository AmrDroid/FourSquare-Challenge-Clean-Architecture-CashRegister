package com.adyen.android.assignment.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    val code: Int,
    val requestId: String
)