package com.pixelart.week6daily2flikrapi.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoData (
    val title : String,
    val owner: String,
    val url: String
):Parcelable