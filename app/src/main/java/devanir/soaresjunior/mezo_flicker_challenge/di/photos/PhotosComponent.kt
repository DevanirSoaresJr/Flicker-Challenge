package devanir.soaresjunior.mezo_flicker_challenge.di.photos

import dagger.Component
import devanir.soaresjunior.mezo_flicker_challenge.di.app.AppComponent
import devanir.soaresjunior.mezo_flicker_challenge.ui.view.MainActivity
import devanir.soaresjunior.mezo_flicker_challenge.ui.view.PhotoListFragment
import devanir.soaresjunior.mezo_flicker_challenge.ui.view.SplashFragment

@PhotosScope
@Component(modules = [PhotosModule::class],dependencies = [AppComponent::class])
interface PhotosComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(photoListFragment: PhotoListFragment)
    fun inject(splashFragment: SplashFragment)

}