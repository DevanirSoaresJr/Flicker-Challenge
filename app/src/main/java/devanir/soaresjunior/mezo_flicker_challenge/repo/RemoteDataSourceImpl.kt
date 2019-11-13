package devanir.soaresjunior.mezo_flicker_challenge.repo

import androidx.lifecycle.LiveData
import devanir.soaresjunior.mezo_flicker_challenge.common.API_KEY
import devanir.soaresjunior.mezo_flicker_challenge.common.FORMAT
import devanir.soaresjunior.mezo_flicker_challenge.common.NO_JSON_CALLBACK
import devanir.soaresjunior.mezo_flicker_challenge.common.SECRET
import devanir.soaresjunior.mezo_flicker_challenge.data.PhotoInfoResponse
import devanir.soaresjunior.mezo_flicker_challenge.data.PhotoListResponse
import devanir.soaresjunior.mezo_flicker_challenge.net.FlickrService
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val flickrService: FlickrService) : RemoteDataSource {
    override fun getNetStatus(): Single<PhotoListResponse> {
        return flickrService.getNetStatus()
    }


    override fun getPhotoDetails(photoId: String): Single<PhotoInfoResponse> {
        return flickrService.getPhotoInfo(API_KEY,photoId, SECRET, FORMAT, NO_JSON_CALLBACK)
    }

    override fun getPhotos(): Single<List<PhotoListResponse>> {
        return flickrService.getPhoto(API_KEY, FORMAT, NO_JSON_CALLBACK)
    }

}