package com.adyen.android.assignment.di

import com.adyen.android.assignment.BuildConfig
import com.adyen.android.assignment.data.source.remote.base.ApiService
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

const val KEY_CLIENT_ID = "client_id"
const val KEY_CLIENT_SECRET = "client_secret"
const val KEY_CLIENT_VERSION = "v"
const val TIME_OUT = 30L
private val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.ROOT)

val networkModule = module {

    single { createService(get()) }

    single { createRetrofit(get(), get()) }

    single { createOkHttpClient() }

    single { Moshi.Builder().build() }

}


fun createOkHttpClient(): OkHttpClient {
    val client = OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
    if (BuildConfig.DEBUG) {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addNetworkInterceptor(interceptor)
    }
    client.addInterceptor { chain ->
        val url = chain.request().url.newBuilder()
            .addQueryParameter(KEY_CLIENT_ID, BuildConfig.CLIENT_ID)
            .addQueryParameter(KEY_CLIENT_SECRET, BuildConfig.CLIENT_SECRET)
            .addQueryParameter(KEY_CLIENT_VERSION, dateFormat.format(Date()))
            .build()
        chain.proceed(
            chain.request()
                .newBuilder()
                .url(url)
                .build()
        )
    }.build()

    return client.build()
}


fun createRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.FOURSQUARE_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okHttpClient)
        .build()
}

fun createService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}



