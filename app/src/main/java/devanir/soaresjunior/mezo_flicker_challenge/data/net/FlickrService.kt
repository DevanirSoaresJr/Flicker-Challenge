package devanir.soaresjunior.mezo_flicker_challenge.data.net

import devanir.soaresjunior.mezo_flicker_challenge.common.FIND_USER
import devanir.soaresjunior.mezo_flicker_challenge.common.PHOTOS_LIST
import devanir.soaresjunior.mezo_flicker_challenge.common.PHOTO_INFO
import devanir.soaresjunior.mezo_flicker_challenge.data.model.PhotoResponse
import devanir.soaresjunior.mezo_flicker_challenge.data.model.photoinfo.PhotoInfoResponse
import devanir.soaresjunior.mezo_flicker_challenge.data.model.UserResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrService {
    // The api key and format query parameters are defined in the network module interceptor
    @GET(PHOTOS_LIST)
    fun getPhotos(
        @Query("user_id") userId: String,
        @Query("per_page") photoPerPage: Int
    ): Single<PhotoResponse>

    @GET(FIND_USER)
    fun getUserId(@Query("username") username: String): Single<UserResponse>

    @GET(PHOTO_INFO)
    fun getPhotoInfo(@Query("photo_id") photoId: String): Single<PhotoInfoResponse>
}