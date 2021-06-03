package com.adyen.android.assignment.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LabeledLatLng(
    val label: String?,
    val lat: Double?,
    val lng: Double?
)
