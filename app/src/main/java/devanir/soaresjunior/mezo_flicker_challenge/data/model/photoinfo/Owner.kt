package devanir.soaresjunior.mezo_flicker_challenge.data.model.photoinfo

import com.google.gson.annotations.SerializedName

data class Owner(
    val nsid: String,
    val username: String,
    val realname: String,
    val location: String,
    val iconserver: String,
    val iconfarm: Int,
    @SerializedName("path_alias")
    val pathAlias: String
)
