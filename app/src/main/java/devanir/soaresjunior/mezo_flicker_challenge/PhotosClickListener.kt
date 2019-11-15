package devanir.soaresjunior.mezo_flicker_challenge

import com.pixelart.week6daily2flikrapi.model.PhotoResponse

interface PhotosClickListener {
    fun onPhotoClicked(photo:PhotoResponse)
}