package devanir.soaresjunior.mezo_flicker_challenge.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import devanir.soaresjunior.mezo_flicker_challenge.data.repo.Repository
import devanir.soaresjunior.mezo_flicker_challenge.ui.photoinfo.PhotosInfoViewModel
import devanir.soaresjunior.mezo_flicker_challenge.ui.photolist.PhotosViewModel
import javax.inject.Inject

class PhotosInfoViewModelFactory @Inject constructor(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PhotosInfoViewModel::class.java))
            PhotosInfoViewModel(repository) as T
        else throw IllegalArgumentException("ViewModel not found")
    }
}
