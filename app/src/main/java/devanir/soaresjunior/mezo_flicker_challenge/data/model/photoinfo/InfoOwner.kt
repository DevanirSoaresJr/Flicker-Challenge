package com.pixelart.week6daily2flikrapi.model.photoinfo

import com.google.gson.annotations.SerializedName

data class InfoOwner(
    val nsid: String,
    val username: String,
    val realname: String,
    val location: String,
    val iconserver: String,
    val iconfarm: Int,
    @SerializedName("path_alias")
    val pathAlias: String
)