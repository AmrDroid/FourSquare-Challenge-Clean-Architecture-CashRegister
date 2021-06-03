package com.adyen.android.assignment.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoDetailResponse(var venue: PhotoDetail?)