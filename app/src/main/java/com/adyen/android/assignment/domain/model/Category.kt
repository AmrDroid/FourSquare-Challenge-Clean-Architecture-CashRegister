package com.adyen.android.assignment.domain.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize


@JsonClass(generateAdapter = true)
@Parcelize
data class Category(
    val id: String?,
    val name: String?,
    val icon: Icon?,
    val pluralName: String?,
    val primary: Boolean,
    val shortName: String?
) : Parcelable {

    fun getIcon(): String = icon?.prefix.plus("100").plus(icon?.suffix)
}