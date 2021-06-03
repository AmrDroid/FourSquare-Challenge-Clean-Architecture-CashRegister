package com.adyen.android.assignment.domain.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize


@JsonClass(generateAdapter = true)
@Parcelize
data class Location(
    val address: String?,
    val city: String?,
    val country: String?,
    val state: String?,
    val distance: Int?,
    val cc: String?,
    val crossStreet: String?,
//    val formattedAddress: List<String>?,
//    val labeledLatLngs: List<LabeledLatLng>?,
    val lat: Double?,
    val lng: Double?,
    val postalCode: String?
) : Parcelable
