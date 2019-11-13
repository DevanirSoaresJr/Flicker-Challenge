package devanir.soaresjunior.mezo_flicker_challenge.di.photosDetails

import dagger.Component
import devanir.soaresjunior.mezo_flicker_challenge.di.app.AppComponent
import devanir.soaresjunior.mezo_flicker_challenge.ui.view.PhotosInfoFragment

@PhotosInfoScope
@Component(modules = [PhotosInfoModule::class], dependencies = [AppComponent::class])
interface PhotosInfoComponent {
    fun inject(photoListFragment: PhotosInfoFragment)
}