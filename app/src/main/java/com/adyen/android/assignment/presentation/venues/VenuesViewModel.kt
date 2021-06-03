package com.adyen.android.assignment.presentation.venues

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.adyen.android.assignment.domain.base.SingleUseCase
import com.adyen.android.assignment.domain.base.UseCaseResponse
import com.adyen.android.assignment.domain.model.*
import com.adyen.android.assignment.domain.usecase.*
import com.adyen.android.assignment.presentation.base.BaseViewModel
import com.adyen.android.assignment.presentation.util.SingleLiveEvent


class VenuesViewModel(
    private val getVenuesUseCase: SingleUseCase<ExploreResponse, String>?,
    private val getPhotosUseCase:  SingleUseCase<PhotoResponse, String>?,
    private val insertVenuesToDbUseCase:  SingleUseCase<List<Long>?, List<Locale>?>?,
    private val getVenuesFromDbUseCase:  SingleUseCase<List<Locale>?, Any?>?,
    private val insertUserLocationToDbUseCase:   SingleUseCase<Long?, UserLocation?>?,
    private val getUserLocationFromDbUseCase:    SingleUseCase<UserLocation?,Any?>?
) : BaseViewModel() {


    private var _venuesData = MutableLiveData<List<Locale>>()
    val venues: LiveData<List<Locale>> = _venuesData

    private var _photoData = MutableLiveData<String>()
    val photo: LiveData<String> = _photoData


    private var completeList = mutableListOf<Locale>()
    private var _isNewLocation = SingleLiveEvent<Boolean>()
    private val isNewLocation = _isNewLocation
    private var isLoadingMore = false
    private var totalCount = 0
    private var ll = "0"


    fun isNewLocation(): Boolean {
        return isNewLocation.value ?: false
    }

    fun clearFormerData() {
        completeList.clear()
        _venuesData.value = completeList
    }

    fun fetchVenues(ll: String) {
        this.ll = ll
        showLoading(true)

        getVenuesUseCase?.invoke(viewModelScope, ll, object : UseCaseResponse<ExploreResponse> {
            override fun onSuccess(result: ExploreResponse?) {

                isLoadingMore = false
                showLoading(false)
                totalCount = result?.response?.totalResults ?: 0
                result?.response?.groups?.get(0)?.items?.let { completeList.addAll(it) }
                _venuesData.value = completeList

                insertVenuesToDb(completeList)
            }

            override fun onError(error: ApiError) {
                Log.e(TAG, "onError: ${error.message}")
                isLoadingMore = false
                showLoading(false)
                handleError(error)
            }

        })
    }


    fun loadMoreItems() {
        showLoading(true)
        isLoadingMore = true
        fetchVenues(ll)
    }

    fun getTotalCount(): Int = totalCount

    fun getLoadingMore(): Boolean = isLoadingMore


    fun insertVenuesToDb(list: List<Locale>?) {
        insertVenuesToDbUseCase?.invoke(viewModelScope, list, object : UseCaseResponse<List<Long>?> {
            override fun onSuccess(result: List<Long>?) {
                Log.i(TAG, "venues inserted successfully: $result")
            }

            override fun onError(error: ApiError) {
                Log.e(TAG, "onError: ${error.message}")
            }
        })
    }


    fun fetchVenuesFromDb() {
        getVenuesFromDbUseCase?.invoke(
            viewModelScope,
            null,
            object : UseCaseResponse<List<Locale>?> {
                override fun onSuccess(result: List<Locale>?) {
                    //Log.i(TAG, "venues were fetched from db successfully: $result")
                    _venuesData.value = result
                }

                override fun onError(error: ApiError) {
                    Log.e(TAG, "onError: ${error.message}")
                    handleError(error)
                }
            })
    }

    fun checkLocation(latitude: String, longitude: String) {
        Log.d(TAG, "checkLocation() called with: latitude = $latitude, longitude = $longitude")

        getUserLocationFromDbUseCase?.invoke(
            viewModelScope,
            null,
            object : UseCaseResponse<UserLocation?> {
                override fun onSuccess(result: UserLocation?) {
                    Log.i(TAG, "Location was fetched successfully: $result")

                    if (result?.longitude == longitude && result.latitude == latitude) {
                        _isNewLocation.value = false
                    } else {
                        _isNewLocation.value = true
                        saveUserLocation(latitude, longitude)
                    }
                }

                override fun onError(error: ApiError) {
                    Log.e(TAG, "onError: ${error.message}")
                    handleError(error)
                }
            })
    }


    private fun saveUserLocation(latitude: String, longitude: String) {
        val location = UserLocation(latitude, longitude)

        insertUserLocationToDbUseCase?.invoke(
            viewModelScope,
            location,
            object : UseCaseResponse<Long?> {
                override fun onSuccess(result: Long?) {
                    Log.i(TAG, "Location was saved in db successfully: $result")
                }

                override fun onError(error: ApiError) {
                    Log.e(TAG, "onError: ${error.message}")
                }
            })
    }


    companion object {

        private val TAG = VenuesViewModel::class.java.name
    }


    fun fetchPhotos(id: String) {
        getPhotosUseCase?.invoke(viewModelScope, id, object : UseCaseResponse<PhotoResponse> {
            override fun onSuccess(result: PhotoResponse?) {
                _photoData.value = result?.response?.getPhoto() ?: ""
            }

            override fun onError(error: ApiError) {
                Log.e(TAG, "onError: ${error.message}")
                handleError(error)
            }

        })

    }



}