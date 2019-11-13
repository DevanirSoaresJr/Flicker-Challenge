package devanir.soaresjunior.mezo_flicker_challenge.ui.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import devanir.soaresjunior.mezo_flicker_challenge.repo.Repository
import devanir.soaresjunior.mezo_flicker_challenge.ui.viewModel.vmdls.PhotosViewModel

class PhotosInfoViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PhotosViewModel(
            repository
        ) as T
    }
}