package com.example.amaroappcatalog.model

import com.squareup.moshi.Json

data class Product(
    var name: String,

    var image: String,
    @Json(name = "regular_price")
    var regularPrice: String,

    @Json(name = "actual_price")
    var actualPrice: String,

    @Json(name = "discount_percentage")
    var discountPercentage: String,

    var installments: String
)