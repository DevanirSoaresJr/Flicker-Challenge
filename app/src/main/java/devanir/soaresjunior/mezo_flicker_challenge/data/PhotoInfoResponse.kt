package devanir.soaresjunior.mezo_flicker_challenge.data


import com.google.gson.annotations.SerializedName

data class PhotoInfoResponse(
    val photo: Photo,
    val stat: String
) {
    data class Photo(
        val id: String,
        val secret: String,
        val server: String,
        val farm: Int,
        val dateuploaded: String,
        val isfavorite: Int,
        val license: String,
        @SerializedName("safety_level")
        val safetyLevel: String,
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
    ) {
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

        data class Title(
            @SerializedName("_content")
            val content: String
        )

        data class Description(
            @SerializedName("_content")
            val content: String
        )

        data class Visibility(
            val ispublic: Int,
            val isfriend: Int,
            val isfamily: Int
        )

        data class Dates(
            val posted: String,
            val taken: String,
            val takengranularity: String,
            val takenunknown: String,
            val lastupdate: String
        )

        data class Editability(
            val cancomment: Int,
            val canaddmeta: Int
        )

        data class Publiceditability(
            val cancomment: Int,
            val canaddmeta: Int
        )

        data class Usage(
            val candownload: Int,
            val canblog: Int,
            val canprint: Int,
            val canshare: Int
        )

        data class Comments(
            @SerializedName("_content")
            val content: String
        )

        data class Notes(
            val note: List<Any>
        )

        data class People(
            val haspeople: Int
        )

        data class Tags(
            val tag: List<Tag>
        ) {
            data class Tag(
                val id: String,
                val author: String,
                val authorname: String,
                val raw: String,
                @SerializedName("_content")
                val content: String,
                @SerializedName("machine_tag")
                val machineTag: Boolean
            )
        }

        data class Location(
            val latitude: String,
            val longitude: String,
            val accuracy: String,
            val context: String,
            val locality: Locality,
            val county: County,
            val region: Region,
            val country: Country,
            val neighbourhood: Neighbourhood
        ) {
            data class Locality(
                @SerializedName("_content")
                val content: String
            )

            data class County(
                @SerializedName("_content")
                val content: String
            )

            data class Region(
                @SerializedName("_content")
                val content: String
            )

            data class Country(
                @SerializedName("_content")
                val content: String
            )

            data class Neighbourhood(
                @SerializedName("_content")
                val content: String
            )
        }

        data class Geoperms(
            val ispublic: Int,
            val iscontact: Int,
            val isfriend: Int,
            val isfamily: Int
        )

        data class Urls(
            val url: List<Url>
        ) {
            data class Url(
                val type: String,
                @SerializedName("_content")
                val content: String
            )
        }
    }
}