package devanir.soaresjunior.mezo_flicker_challenge

import devanir.soaresjunior.mezo_flicker_challenge.data.PhotoListResponse

interface PhotosClickListener {
    fun onPhotoClicked(photo:PhotoListResponse)
}