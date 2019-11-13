package devanir.soaresjunior.mezo_flicker_challenge

import android.app.Application
import devanir.soaresjunior.mezo_flicker_challenge.di.app.AppComponent
import devanir.soaresjunior.mezo_flicker_challenge.di.app.DaggerAppComponent
import devanir.soaresjunior.mezo_flicker_challenge.di.app.NetworkModule
import devanir.soaresjunior.mezo_flicker_challenge.di.app.RepositoryModule

class FlickrApp: Application() {

    override fun onCreate() {
        super.onCreate()
        component()
    }

     fun component(): AppComponent =
        DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .repositoryModule(RepositoryModule())
            .build()
}
