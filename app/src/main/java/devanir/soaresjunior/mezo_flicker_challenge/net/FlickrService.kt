package devanir.soaresjunior.mezo_flicker_challenge.net

import devanir.soaresjunior.mezo_flicker_challenge.common.PHOTOS_LIST
import devanir.soaresjunior.mezo_flicker_challenge.common.PHOTO_INFO
import devanir.soaresjunior.mezo_flicker_challenge.data.PhotoInfoResponse
import devanir.soaresjunior.mezo_flicker_challenge.data.PhotoListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrService {
    @GET(PHOTOS_LIST)
    fun getPhoto(
        @Query("api_key") apiKey : String,
        @Query("format") format: String,
        @Query("nojsoncallback") noJsonCallback: Int
    ): Single<List<PhotoListResponse>>

    @GET(PHOTO_INFO)
    fun getPhotoInfo(
        @Query("api_key") apiKey : String,
        @Query("photo_id") photoId: String,
        @Query("secret") secret: String,
        @Query("format") format: String,
        @Query("nojsoncallback") noJsonCallback: Int
    ): Single<PhotoInfoResponse>

    @GET("stat")
    fun getNetStatus():Single<PhotoListResponse>
}