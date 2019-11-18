package devanir.soaresjunior.mezo_flicker_challenge.data.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoDto(
    val id: String,
    val title: String,
    val owner: String,
    val url: String
) : Parcelable
