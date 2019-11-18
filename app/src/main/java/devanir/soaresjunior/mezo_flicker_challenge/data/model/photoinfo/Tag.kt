package devanir.soaresjunior.mezo_flicker_challenge.data.model.photoinfo

import com.google.gson.annotations.SerializedName

data class Tag(
    val id: String,
    val author: String,
    val authorname: String,
    val raw: String,
    @SerializedName("_content")
    val content: String,
    @SerializedName("machine_tag")
    val machineTag: Int
)
