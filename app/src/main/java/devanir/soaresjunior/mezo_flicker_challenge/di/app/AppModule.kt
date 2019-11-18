package devanir.soaresjunior.mezo_flicker_challenge.di.app

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import devanir.soaresjunior.mezo_flicker_challenge.data.net.FlickrService
import devanir.soaresjunior.mezo_flicker_challenge.data.repo.Repository
import devanir.soaresjunior.mezo_flicker_challenge.data.repo.RepositoryImpl

@Module
class AppModule(private val application: Application) {

    @Provides
    @AppScope
    fun providesContext(): Context = application

    @Provides
    @AppScope
    fun providesRepository(networkService: FlickrService): Repository =
        RepositoryImpl(networkService)
}
