package com.pixelart.week6daily2flikrapi.model.photoinfo

import com.google.gson.annotations.SerializedName

data class InfoPeople(
    @SerializedName("haspeople")
    val hasPeople: Int
)