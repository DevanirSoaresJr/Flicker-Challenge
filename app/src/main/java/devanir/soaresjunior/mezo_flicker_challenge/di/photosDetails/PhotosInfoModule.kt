package devanir.soaresjunior.mezo_flicker_challenge.di.photosDetails

import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import devanir.soaresjunior.mezo_flicker_challenge.di.photos.PhotosScope
import devanir.soaresjunior.mezo_flicker_challenge.repo.Repository
import devanir.soaresjunior.mezo_flicker_challenge.ui.view.PhotosInfoFragment
import devanir.soaresjunior.mezo_flicker_challenge.ui.viewModel.vmdls.PhotosViewModel
import devanir.soaresjunior.mezo_flicker_challenge.ui.viewModel.factory.PhotosInfoViewModelFactory

@Module
class PhotosInfoModule(private val photosInfoFragment: PhotosInfoFragment) {

    @Provides
    @PhotosScope
    fun providePhotosInfoViewModelFactory(repository: Repository): PhotosInfoViewModelFactory {
        return PhotosInfoViewModelFactory(repository)
    }

    @Provides
    @PhotosScope
    fun providePhotosInfoViewModel(photosViewModelFactory: PhotosInfoViewModelFactory): PhotosViewModel {
        return ViewModelProviders.of(photosInfoFragment, photosViewModelFactory)
            .get(PhotosViewModel::class.java)       }
}