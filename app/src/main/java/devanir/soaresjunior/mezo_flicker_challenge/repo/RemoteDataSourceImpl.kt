package devanir.soaresjunior.mezo_flicker_challenge.repo

import com.pixelart.week6daily2flikrapi.model.PhotoResponse
import com.pixelart.week6daily2flikrapi.model.photoinfo.InfoResponse
import devanir.soaresjunior.mezo_flicker_challenge.common.API_KEY
import devanir.soaresjunior.mezo_flicker_challenge.common.FORMAT
import devanir.soaresjunior.mezo_flicker_challenge.common.NO_JSON_CALLBACK
import devanir.soaresjunior.mezo_flicker_challenge.common.SECRET
import devanir.soaresjunior.mezo_flicker_challenge.net.FlickrService
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val flickrService: FlickrService) : RemoteDataSource {
    override fun getNetStatus(): Single<PhotoResponse> {
        return flickrService.getNetStatus()
    }


    override fun getPhotoDetails(photoId: String): Single<InfoResponse> {
        return flickrService.getPhotoInfo(API_KEY,photoId, SECRET, FORMAT, NO_JSON_CALLBACK)
    }

    override fun getPhotos(): Single<List<PhotoResponse>> {
        return flickrService.getPhoto(API_KEY, FORMAT, NO_JSON_CALLBACK)
    }

}