package devanir.soaresjunior.mezo_flicker_challenge.data.model


data class PhotoResponse(
    val photos: Photos,
    val stat: String,
    val code: Int,
    val message: String
)

data class Photos(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: String,
    val photo: List<Photo>
)

data class Photo(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String,
    val ispublic: Int,
    val isfriend: Int,
    val isfamily: Int
)
