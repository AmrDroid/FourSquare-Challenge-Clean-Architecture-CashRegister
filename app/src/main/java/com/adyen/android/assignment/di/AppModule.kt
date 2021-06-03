package com.adyen.android.assignment.di

import android.app.NotificationManager
import android.content.Context
import com.adyen.android.assignment.data.repository.UserRepositoryImp
import com.adyen.android.assignment.data.repository.VenueRepositoryImp
import com.adyen.android.assignment.data.source.local.UserLocalDataSource
import com.adyen.android.assignment.data.source.local.UserLocalDataSourceImp
import com.adyen.android.assignment.data.source.local.base.AppDatabase
import com.adyen.android.assignment.data.source.local.VenueLocalDataSource
import com.adyen.android.assignment.data.source.local.VenueLocalDataSourceImp
import com.adyen.android.assignment.data.source.remote.UserRemoteDataSource
import com.adyen.android.assignment.data.source.remote.UserRemoteDataSourceImp
import com.adyen.android.assignment.data.source.remote.VenueRemoteDataSource
import com.adyen.android.assignment.data.source.remote.VenueRemoteDataSourceImp
import com.adyen.android.assignment.data.source.remote.base.ApiService
import com.adyen.android.assignment.domain.base.SingleUseCase
import com.adyen.android.assignment.domain.model.*
import com.adyen.android.assignment.domain.repository.UserRepository
import com.adyen.android.assignment.domain.repository.VenueRepository
import com.adyen.android.assignment.domain.usecase.*
import com.adyen.android.assignment.presentation.NetworkStateBroadcastReceiver
import com.adyen.android.assignment.presentation.detail.DetailViewModel
import com.adyen.android.assignment.presentation.venues.VenuesViewModel
import com.google.android.gms.location.LocationRequest
import org.koin.core.qualifier.named
import org.koin.dsl.module


val appModule = module {

    single {
        NetworkStateBroadcastReceiver()
    }

    single {
        createNotificationManager(get())
    }

    single {
        LocationRequest()
    }

    single { createVenuesRepository(get(), get()) }

    single { createVenuesLocalDataSource(get()) }

    single { createVenuesRemoteDataSource(get()) }


    //Venues
    single {
        VenuesViewModel(
            get(named("search")),
            get(named("getphotos")),
            get(named("insertvenues")),
            get(named("localvenues")),
            get(named("insertlocation")),
            get(named("getlocation"))
        )
    }

    single(named("search")) { createGetVenuesUseCase(get()) }

    single(named("getphotos")) { createGetPhotosUseCase(get()) }

    single(named("insertvenues")) { createInsertVenuesToDbUseCase(get()) }

    single(named("localvenues")) { createGetVenuesFromDbUseCase(get()) }

    single(named("insertlocation")) { createInsertUserLocationToDbUseCase(get()) }

    single(named("getlocation")) { createGetUserLocationFromDbUseCase(get()) }


    //Detail
    single { DetailViewModel(get()) }

    single { createGetVenueDetailUseCase(get()) }


    //User
    single { createUserRepository(get(), get()) }

    single { createUserLocalDataSource(get()) }

    single { createUserRemoteDataSource(get()) }


}


fun createNotificationManager(context: Context): NotificationManager {
    return context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
}


fun createGetVenuesUseCase(venueRepository: VenueRepository): SingleUseCase<ExploreResponse, String> {
    return GetVenuesUseCase(venueRepository)
}

fun createGetPhotosUseCase(venueRepository: VenueRepository): SingleUseCase<PhotoResponse, String> {
    return GetPhotosUseCase(venueRepository)
}

fun createGetVenuesFromDbUseCase(venueRepository: VenueRepository): SingleUseCase<List<Locale>?, Any?> {
    return GetVenuesFromDbUseCase(venueRepository)
}

fun createInsertVenuesToDbUseCase(venueRepository: VenueRepository): SingleUseCase<List<Long>?, List<Locale>?> {
    return InsertVenuesToDbUseCase(venueRepository)
}

fun createGetVenueDetailUseCase(venueRepository: VenueRepository): SingleUseCase<DetailResponse, String> {
    return GetVenueDetailUseCase(venueRepository)
}

fun createVenuesRepository(
    venueRemoteDataSource: VenueRemoteDataSource,
    venueLocalDataSource: VenueLocalDataSource
): VenueRepository {
    return VenueRepositoryImp(venueRemoteDataSource, venueLocalDataSource)
}

fun createVenuesLocalDataSource(appDatabase: AppDatabase): VenueLocalDataSource {
    return VenueLocalDataSourceImp(appDatabase)
}

fun createVenuesRemoteDataSource(apiService: ApiService): VenueRemoteDataSource {
    return VenueRemoteDataSourceImp(apiService)
}

fun createUserRepository(
    userRemoteDataSource: UserRemoteDataSource,
    userLocalDataSource: UserLocalDataSource
): UserRepository {
    return UserRepositoryImp(userRemoteDataSource, userLocalDataSource)
}

fun createUserLocalDataSource(appDatabase: AppDatabase): UserLocalDataSource {
    return UserLocalDataSourceImp(appDatabase)
}

fun createUserRemoteDataSource(apiService: ApiService): UserRemoteDataSource {
    return UserRemoteDataSourceImp(apiService)
}

fun createInsertUserLocationToDbUseCase(userRepository: UserRepository): SingleUseCase<Long?, UserLocation?> {
    return InsertUserLocationToDbUseCase(userRepository)
}

fun createGetUserLocationFromDbUseCase(userRepository: UserRepository): SingleUseCase<UserLocation?, Any?> {
    return GetUserLocationFromDbUseCase(userRepository)
}



