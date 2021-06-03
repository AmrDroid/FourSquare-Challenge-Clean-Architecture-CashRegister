package com.adyen.android.assignment.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SuggestedBounds(
    val ne: LatLng?,
    val sw: LatLng?
)
