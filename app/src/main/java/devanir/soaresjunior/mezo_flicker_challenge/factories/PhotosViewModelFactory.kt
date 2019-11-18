package devanir.soaresjunior.mezo_flicker_challenge.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import devanir.soaresjunior.mezo_flicker_challenge.data.repo.Repository
import devanir.soaresjunior.mezo_flicker_challenge.ui.photolist.PhotosViewModel
import javax.inject.Inject

class PhotosViewModelFactory @Inject constructor(private val repository: Repository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PhotosViewModel::class.java))
            PhotosViewModel(repository) as T
        else throw IllegalArgumentException("ViewModel not found")
    }
}
