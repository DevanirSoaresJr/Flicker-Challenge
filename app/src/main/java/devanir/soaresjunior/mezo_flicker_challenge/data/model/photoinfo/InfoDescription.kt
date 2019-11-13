package com.pixelart.week6daily2flikrapi.model.photoinfo

import com.google.gson.annotations.SerializedName

data class InfoDescription(
    @SerializedName("_content")
    val content: String
)