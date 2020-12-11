package com.example.amaroappcatalog.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Size(
    var available: Boolean,
    var size: String
): Parcelable