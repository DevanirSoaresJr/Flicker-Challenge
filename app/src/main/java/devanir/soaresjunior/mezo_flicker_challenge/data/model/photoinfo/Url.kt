package devanir.soaresjunior.mezo_flicker_challenge.data.model.photoinfo

import com.google.gson.annotations.SerializedName

data class Url(
    val type: String,
    @SerializedName("_content")
    val content: String
)
