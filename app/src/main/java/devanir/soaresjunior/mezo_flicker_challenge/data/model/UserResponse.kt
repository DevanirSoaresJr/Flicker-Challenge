package devanir.soaresjunior.mezo_flicker_challenge.data.model


import com.google.gson.annotations.SerializedName

data class UserResponse(
    val user: User,
    val stat: String,
    val code: Int,
    val message: String
)

data class User(
    val id: String,
    val nsid: String,
    val username: Username
)

data class Username(
    @SerializedName("_content")
    val content: String
)
