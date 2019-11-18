package devanir.soaresjunior.mezo_flicker_challenge.data.repo

import androidx.lifecycle.LiveData
import devanir.soaresjunior.mezo_flicker_challenge.common.NetworkState
import devanir.soaresjunior.mezo_flicker_challenge.data.model.PhotoResponse
import devanir.soaresjunior.mezo_flicker_challenge.data.model.photoinfo.PhotoInfoResponse
import devanir.soaresjunior.mezo_flicker_challenge.data.model.UserResponse

interface Repository {
    fun getUserId(username: String): LiveData<NetworkState<UserResponse>>
    fun getPhotos(userId: String, photoPerPage: Int): LiveData<NetworkState<PhotoResponse>>
    fun getPhotoInfo(photoId: String): LiveData<NetworkState<PhotoInfoResponse>>
    fun dispose()
}
