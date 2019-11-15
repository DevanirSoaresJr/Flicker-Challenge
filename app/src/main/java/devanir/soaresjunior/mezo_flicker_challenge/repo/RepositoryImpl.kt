package devanir.soaresjunior.mezo_flicker_challenge.repo

import com.pixelart.week6daily2flikrapi.model.PhotoResponse
import com.pixelart.week6daily2flikrapi.model.photoinfo.InfoResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource):
    Repository {


    override fun getPhotoDetails(photoId: String): Single<InfoResponse> {
        return remoteDataSource.getPhotoDetails(photoId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()   )    }

    override fun getPhotos(
        apiKey: String,
        format: String,
        noJsonCallback: Int
    ): Single<List<PhotoResponse>> {
        return remoteDataSource.getPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()   )
    }
    override fun getNetStatus(): Single<PhotoResponse> {
        return remoteDataSource.getNetStatus()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()   )    }

}