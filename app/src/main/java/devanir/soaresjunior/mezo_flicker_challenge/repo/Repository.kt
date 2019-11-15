package devanir.soaresjunior.mezo_flicker_challenge.repo

import com.pixelart.week6daily2flikrapi.model.PhotoResponse
import com.pixelart.week6daily2flikrapi.model.photoinfo.InfoResponse
import io.reactivex.Single

interface Repository {
    fun showImage(photoResponse: PhotoResponse)
    fun getPhotos(apiKey: String, format: String, noJsonCallback: Int): Single<List<PhotoResponse>>
    fun getPhotoDetails(photoId: String): Single<InfoResponse>
    fun getNetStatus(): Single<PhotoResponse>


}