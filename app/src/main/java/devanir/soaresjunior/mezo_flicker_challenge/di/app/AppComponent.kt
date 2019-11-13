package devanir.soaresjunior.mezo_flicker_challenge.di.app

import dagger.Component
import devanir.soaresjunior.mezo_flicker_challenge.FlickrApp
import devanir.soaresjunior.mezo_flicker_challenge.repo.Repository
import devanir.soaresjunior.mezo_flicker_challenge.ui.view.MainActivity
import devanir.soaresjunior.mezo_flicker_challenge.ui.view.SplashFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface AppComponent {
    fun inject(flickrApp: FlickrApp)
    fun inject(splashFragment: SplashFragment)
    fun inject(mainActivity: MainActivity)
    fun repository(): Repository
}