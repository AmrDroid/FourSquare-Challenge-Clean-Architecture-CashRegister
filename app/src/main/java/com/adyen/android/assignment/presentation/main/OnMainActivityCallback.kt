package com.adyen.android.assignment.presentation.main

import com.adyen.android.assignment.domain.model.Venue

/**
 * To make an interaction between [MainActivity] & its child
 * */
interface OnMainActivityCallback {

    fun navigateToDetail(venue: Venue)
}