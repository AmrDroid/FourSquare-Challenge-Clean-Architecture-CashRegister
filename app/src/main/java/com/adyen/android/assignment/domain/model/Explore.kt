package com.adyen.android.assignment.domain.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Explore(
    val groups: List<Group>?,
    val headerFullLocation: String?,
    val headerLocation: String?,
    val totalResults: Int?,
    val headerLocationGranularity: String?,
    val suggestedBounds: SuggestedBounds?,
    val suggestedRadius: Int?,
    val warning: Warning?

)