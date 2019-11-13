package devanir.soaresjunior.mezo_flicker_challenge.repo

import androidx.lifecycle.LiveData
import devanir.soaresjunior.mezo_flicker_challenge.data.PhotoInfoResponse
import devanir.soaresjunior.mezo_flicker_challenge.data.PhotoListResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource):
    Repository {


    override fun getPhotoDetails(photoId: String): Single<PhotoInfoResponse> {
        return remoteDataSource.getPhotoDetails(photoId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()   )    }

    override fun getPhotos(): Single<List<PhotoListResponse>> {
        return remoteDataSource.getPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()   )
    }
    override fun getNetStatus(): Single<PhotoListResponse> {
        return remoteDataSource.getNetStatus()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()   )    }

}