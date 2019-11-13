package com.pixelart.week6daily2flikrapi.model.photoinfo

import com.google.gson.annotations.SerializedName

data class InfoPhoto(
    val id : String,
    val secret: String,
    val server: String,
    val farm: Int,
    val dateuploaded: String,
    val isfavorite: String,
    val license: String,
    @SerializedName("safety_level")
    val safetyLevel: String,
    val rotation: Int,
    val originalsecret: String,
    val owner: InfoOwner,
    val title: InfoTitle,
    val description: InfoDescription,
    val visibility: InfoVisibility,
    val dates: InfoDates,
    val views: String,
    val editability: InfoEditability,
    val publiceditability: InfoPubliceditability,
    val usage: InfoUsage,
    val comments: InfoComments,
    val notes: InfoNotes,
    val people: InfoPeople,
    val tags: InfoTags,
    val urls: InfoUrls,
    val media: String
)