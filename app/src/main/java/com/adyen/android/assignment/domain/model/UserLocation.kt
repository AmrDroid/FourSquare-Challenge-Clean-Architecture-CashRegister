package com.adyen.android.assignment.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserLocation(
    @PrimaryKey var id: Int ,
    var latitude: String = "",
    var longitude: String = ""
) {
    constructor(latitude: String, longitude: String) : this(0, latitude, longitude)
}