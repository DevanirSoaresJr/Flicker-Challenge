package com.pixelart.week6daily2flikrapi.model.photoinfo

import com.google.gson.annotations.SerializedName

data class InfoComments (
    @SerializedName("_content")
    val content: String
)