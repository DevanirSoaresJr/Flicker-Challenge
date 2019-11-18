package devanir.soaresjunior.mezo_flicker_challenge

import android.app.Application
import devanir.soaresjunior.mezo_flicker_challenge.di.app.AppComponent
import devanir.soaresjunior.mezo_flicker_challenge.di.app.AppModule
import devanir.soaresjunior.mezo_flicker_challenge.di.app.DaggerAppComponent
import devanir.soaresjunior.mezo_flicker_challenge.di.network.NetworkModule

class FlickrApp: Application() {
    val applicationComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .appModule(AppModule(this))
            .build()
    }
}
