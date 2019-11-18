package devanir.soaresjunior.mezo_flicker_challenge.ui.photoinfo

import androidx.lifecycle.ViewModel
import devanir.soaresjunior.mezo_flicker_challenge.data.repo.Repository
import javax.inject.Inject

class PhotosInfoViewModel  @Inject constructor(private val repository: Repository) : ViewModel() {
    fun fetchPhotoInfo(photoId: String) = repository.getPhotoInfo(photoId)

    override fun onCleared() {
        repository.dispose()
    }
}
