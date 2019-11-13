package devanir.soaresjunior.mezo_flicker_challenge.di.app

import dagger.Module
import dagger.Provides
import devanir.soaresjunior.mezo_flicker_challenge.net.FlickrService
import devanir.soaresjunior.mezo_flicker_challenge.repo.RemoteDataSource
import devanir.soaresjunior.mezo_flicker_challenge.repo.RemoteDataSourceImpl
import devanir.soaresjunior.mezo_flicker_challenge.repo.Repository
import devanir.soaresjunior.mezo_flicker_challenge.repo.RepositoryImpl
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(remoteDataSource: RemoteDataSource): Repository {
        return RepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(flickrService: FlickrService): RemoteDataSource {
        return RemoteDataSourceImpl(flickrService)
    }
}