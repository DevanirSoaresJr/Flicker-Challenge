package devanir.soaresjunior.mezo_flicker_challenge.di.fragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import devanir.soaresjunior.mezo_flicker_challenge.factories.PhotosInfoViewModelFactory
import devanir.soaresjunior.mezo_flicker_challenge.factories.PhotosViewModelFactory
import devanir.soaresjunior.mezo_flicker_challenge.ui.photoinfo.PhotosInfoViewModel
import devanir.soaresjunior.mezo_flicker_challenge.ui.photolist.PhotosViewModel

@Module
class FragmentModule(private val fragment: Fragment) {
    @Provides
    @FragmentScope
    fun providesPhotosViewModel(factory: PhotosViewModelFactory) =
        ViewModelProviders.of(fragment, factory).get(PhotosViewModel::class.java)

    @Provides
    @FragmentScope
    fun providesPhotoInfoViewModel(factory: PhotosInfoViewModelFactory) =
        ViewModelProviders.of(fragment, factory).get(PhotosInfoViewModel::class.java)
}
