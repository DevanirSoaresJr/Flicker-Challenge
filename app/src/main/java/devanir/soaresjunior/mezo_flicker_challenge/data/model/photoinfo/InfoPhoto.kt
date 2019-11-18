package devanir.soaresjunior.mezo_flicker_challenge.data.model.photoinfo

import com.google.gson.annotations.SerializedName

data class InfoPhoto(
    val id: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val dateuploaded: String,
    val isfavorite: Int,
    val license: Int,
    @SerializedName("safety_level")
    val safetyLevel: Int,
    val rotation: Int,
    val owner: Owner,
    val title: Title,
    val description: Description,
    val visibility: Visibility,
    val dates: Dates,
    val views: String,
    val editability: Editability,
    val publiceditability: Publiceditability,
    val usage: Usage,
    val comments: Comments,
    val notes: Notes,
    val people: People,
    val tags: Tags,
    val location: Location,
    val geoperms: Geoperms,
    val urls: Urls,
    val media: String
)
