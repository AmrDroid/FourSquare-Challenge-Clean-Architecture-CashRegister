package com.adyen.android.assignment.data.source.local

import com.adyen.android.assignment.domain.model.Locale

interface VenueLocalDataSource {

    suspend fun getAllVenues(): List<Locale>?

    suspend fun insertAllVenues(list: List<Locale>?) : List<Long>?

}