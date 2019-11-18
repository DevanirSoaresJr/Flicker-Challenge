package devanir.soaresjunior.mezo_flicker_challenge.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import devanir.soaresjunior.mezo_flicker_challenge.common.NetworkState
import devanir.soaresjunior.mezo_flicker_challenge.data.model.PhotoResponse
import devanir.soaresjunior.mezo_flicker_challenge.data.model.photoinfo.PhotoInfoResponse
import devanir.soaresjunior.mezo_flicker_challenge.data.model.UserResponse
import devanir.soaresjunior.mezo_flicker_challenge.data.net.FlickrService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val networkService: FlickrService) : Repository {
    private val compositeDisposable = CompositeDisposable()

    override fun getUserId(username: String): LiveData<NetworkState<UserResponse>> {
        val userLiveData = MutableLiveData<NetworkState<UserResponse>>()
        // Set the state to loading
        userLiveData.value = NetworkState.Loading()

        compositeDisposable.add(
            networkService.getUserId(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { response ->
                        userLiveData.value = NetworkState.Success(response)
                    },
                    { error ->
                        userLiveData.value = NetworkState.Failure(error)
                        error.printStackTrace()
                    }
                )
        )
        return userLiveData
    }

    override fun getPhotos(userId: String, photoPerPage: Int): LiveData<NetworkState<PhotoResponse>> {
        val photoLiveData = MutableLiveData<NetworkState<PhotoResponse>>()
        photoLiveData.value = NetworkState.Loading()

        compositeDisposable.add(
            networkService.getPhotos(userId, photoPerPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { response ->
                        photoLiveData.value = NetworkState.Success(response)
                    },
                    { error ->
                        photoLiveData.value = NetworkState.Failure(error)
                        error.printStackTrace()
                    }
                )
        )
        return photoLiveData
    }

    override fun getPhotoInfo(photoId: String): LiveData<NetworkState<PhotoInfoResponse>> {
        val infoLiveData = MutableLiveData<NetworkState<PhotoInfoResponse>>()
        infoLiveData.value = NetworkState.Loading()

        compositeDisposable.add(
            networkService.getPhotoInfo(photoId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { response ->
                        infoLiveData.value = NetworkState.Success(response)
                    },
                    { error ->
                        infoLiveData.value = NetworkState.Failure(error)
                        error.printStackTrace()
                    }
                )
        )
        return infoLiveData
    }

    override fun dispose() {
        compositeDisposable.dispose()
    }
}
