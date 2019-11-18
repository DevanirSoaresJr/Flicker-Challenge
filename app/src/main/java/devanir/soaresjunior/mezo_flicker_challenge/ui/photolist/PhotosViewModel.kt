package devanir.soaresjunior.mezo_flicker_challenge.ui.photolist

import androidx.lifecycle.ViewModel
import devanir.soaresjunior.mezo_flicker_challenge.data.repo.Repository
import javax.inject.Inject

class PhotosViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun fetchPhotos(userId: String, photoPerPage: Int) = repository.getPhotos(userId, photoPerPage)
    fun fetchUserId(username: String) = repository.getUserId(username)

    override fun onCleared() {
        repository.dispose()
    }
}
