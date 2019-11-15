package devanir.soaresjunior.mezo_flicker_challenge.net

import com.pixelart.week6daily2flikrapi.model.PhotoResponse
import com.pixelart.week6daily2flikrapi.model.photoinfo.InfoResponse
import devanir.soaresjunior.mezo_flicker_challenge.common.PHOTOS_LIST
import devanir.soaresjunior.mezo_flicker_challenge.common.PHOTO_INFO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrService {
    @GET(PHOTOS_LIST)
    fun getPhoto(
        @Query("api_key") apiKey : String,
        @Query("format") format: String,
        @Query("nojsoncallback") noJsonCallback: Int
    ): Single<List<PhotoResponse>>

    @GET(PHOTO_INFO)
    fun getPhotoInfo(
        @Query("api_key") apiKey : String,
        @Query("photo_id") photoId: String,
        @Query("secret") secret: String,
        @Query("format") format: String,
        @Query("nojsoncallback") noJsonCallback: Int
    ): Single<InfoResponse>

    @GET("stat")
    fun getNetStatus():Single<PhotoResponse>
}