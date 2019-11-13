package devanir.soaresjunior.mezo_flicker_challenge.repo

import androidx.lifecycle.LiveData
import devanir.soaresjunior.mezo_flicker_challenge.data.PhotoInfoResponse
import devanir.soaresjunior.mezo_flicker_challenge.data.PhotoListResponse
import io.reactivex.Single

interface Repository {
    fun getPhotos(): Single<List<PhotoListResponse>>
    fun getPhotoDetails(photoId: String): Single<PhotoInfoResponse>
    fun getNetStatus(): Single<PhotoListResponse>

}