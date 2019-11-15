package devanir.soaresjunior.mezo_flicker_challenge.ui.viewModel.vmdls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pixelart.week6daily2flikrapi.model.PhotoResponse
import devanir.soaresjunior.mezo_flicker_challenge.common.API_KEY
import devanir.soaresjunior.mezo_flicker_challenge.common.FORMAT
import devanir.soaresjunior.mezo_flicker_challenge.common.NO_JSON_CALLBACK
import devanir.soaresjunior.mezo_flicker_challenge.repo.Repository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PhotosViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    private val progressObservable = MutableLiveData<Boolean>()
    private val photosObservable: MutableLiveData<List<PhotoResponse>> = MutableLiveData()
    private val errorObservable: MutableLiveData<Boolean> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val netStatusLiveData = MutableLiveData<PhotoResponse>()


    fun getPhotos() {
        compositeDisposable.add(
            repository.getPhotos(API_KEY, FORMAT, NO_JSON_CALLBACK)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<PhotoResponse> {
                    override fun onSuccess(t: PhotoResponse) {
                        repository.showImage(t)
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {

                    }

                }))
    }

    fun getNetStatus(): LiveData<PhotoResponse> {
        compositeDisposable.add(repository.getNetStatus()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(
                {
                    netStatusLiveData.value = it
                },
                {
                    //If the server health is OK then the application should proceed to the “List Screen”.
                    //If the server health is NOT OK then the application should display a “Retry Action” widget.
                    error("Network Error")
                }
            )
        )
        return netStatusLiveData
    }

    fun getPhotosObservable() = photosObservable
    fun getProgressObservable() = progressObservable
    fun getErrorObservable() = errorObservable

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()

    }


}