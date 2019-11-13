package devanir.soaresjunior.mezo_flicker_challenge.ui.viewModel.vmdls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import devanir.soaresjunior.mezo_flicker_challenge.data.PhotoListResponse
import devanir.soaresjunior.mezo_flicker_challenge.repo.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PhotosViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    private val progressObservable = MutableLiveData<Boolean>()
    private val photosObservable: MutableLiveData<List<PhotoListResponse>> = MutableLiveData()
    private val errorObservable: MutableLiveData<Boolean> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val netStatusLiveData = MutableLiveData<PhotoListResponse>()


    fun getPhotos() {
        compositeDisposable.add(
            repository.getPhotos()
                .doOnSubscribe { progressObservable.postValue(true) }
                .doOnError { progressObservable.value = false }
                .subscribe({ photos ->
                    photosObservable.value = photos
                    progressObservable.value = false
                }, {errorObservable.value = true})
        )
    }
    fun getNetStatus(): LiveData<PhotoListResponse> {
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