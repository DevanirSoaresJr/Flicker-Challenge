package com.pixelart.week6daily2flikrapi.model

data class Photo (
    val id : String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: String,
    val title: String,
    val ispublic: String,
    val isfriend: String,
    val isfamily: String
)