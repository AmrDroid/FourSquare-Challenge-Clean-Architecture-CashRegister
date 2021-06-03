package com.adyen.android.assignment.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExploreResponse(
    var meta: Meta?,
    var response: Explore?)