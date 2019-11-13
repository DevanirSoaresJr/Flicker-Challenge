package devanir.soaresjunior.mezo_flicker_challenge.di.photos

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import devanir.soaresjunior.mezo_flicker_challenge.repo.Repository
import devanir.soaresjunior.mezo_flicker_challenge.ui.view.MainActivity
import devanir.soaresjunior.mezo_flicker_challenge.ui.viewModel.vmdls.PhotosViewModel
import devanir.soaresjunior.mezo_flicker_challenge.ui.viewModel.factory.PhotosViewModelFactory

@Module
class PhotosModule(private val activity: AppCompatActivity) {
    @Provides
    @PhotosScope
    fun providePhotosViewModelFactory(repository: Repository): PhotosViewModelFactory {
        return PhotosViewModelFactory(repository)
    }

    @Provides
    @PhotosScope
    fun providePhotosViewModel(photosViewModelFactory: PhotosViewModelFactory): PhotosViewModel {
        return ViewModelProviders.of(activity, photosViewModelFactory)
            .get(PhotosViewModel::class.java)    }


}