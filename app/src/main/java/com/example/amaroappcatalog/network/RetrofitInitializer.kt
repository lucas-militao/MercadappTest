package com.example.amaroappcatalog.network

import com.example.amaroappcatalog.model.Product
import com.example.amaroappcatalog.model.ProductList
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

val BASE_URL = "https://www.mocky.io/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface AmaroApi {
    @GET("59b6a65a0f0000e90471257d/")
    fun getCatalog():
            Call<ProductList>
}

object AmaroCatalogApi {
    val RETROFIT: AmaroApi by lazy {
        retrofit.create(AmaroApi::class.java)
    }
}

