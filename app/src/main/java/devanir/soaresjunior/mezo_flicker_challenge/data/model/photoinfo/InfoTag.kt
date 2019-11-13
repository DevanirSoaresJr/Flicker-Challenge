package com.pixelart.week6daily2flikrapi.model.photoinfo

import com.google.gson.annotations.SerializedName

data class InfoTag(
    val id: String,
    val author: String,
    val authorname: String,
    val raw: String,
    @SerializedName("_content")
    val content: String,
    @SerializedName("machine_tag")
    val machineTag: Boolean
)