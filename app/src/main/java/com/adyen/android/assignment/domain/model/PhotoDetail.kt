package com.adyen.android.assignment.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoDetail(
    var photos: Photos?
) {
    fun getPhoto(): String = try {
        val photoList = photos?.groups?.get(0)?.items
        if (photoList.isNullOrEmpty()) ""
        else photoList[0].let {
            it.prefix.plus(1024).plus(it.suffix)
        }
    } catch (e: IndexOutOfBoundsException) {
        e.printStackTrace()
        ""
    }
}