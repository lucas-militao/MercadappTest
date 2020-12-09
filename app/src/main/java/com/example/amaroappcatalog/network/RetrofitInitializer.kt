package com.example.amaroappcatalog.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

val BASE_URL = "https://www.mocky.io/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface AmaroCatalogApiService {
    @GET("59b6a65a0f0000e90471257d/")
    fun getProperties():
            Call<String>
}

object AmaroCatalogApi {
    val retrofitService: AmaroCatalogApiService by lazy {
        retrofit.create(AmaroCatalogApiService::class.java)
    }
}


//val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
//    .addCallAdapterFactory(CoroutineCallAdapterFactory())
//    .baseUrl(BASE_URL)
//    .build()

