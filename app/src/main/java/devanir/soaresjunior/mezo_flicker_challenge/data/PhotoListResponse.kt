package devanir.soaresjunior.mezo_flicker_challenge.data


import com.google.gson.annotations.SerializedName

data class PhotoListResponse(
    val photos: Photos,
    val stat: String
) {
    data class Photos(
        val page: Int,
        val pages: Int,
        val perpage: Int,
        val total: String,
        val photo: List<Photo>
    ) {
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
    }
}