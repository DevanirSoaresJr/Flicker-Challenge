package devanir.soaresjunior.mezo_flicker_challenge.di.network

import dagger.Module
import dagger.Provides
import devanir.soaresjunior.mezo_flicker_challenge.common.API_KEY
import devanir.soaresjunior.mezo_flicker_challenge.common.BASE_URL
import devanir.soaresjunior.mezo_flicker_challenge.common.FORMAT
import devanir.soaresjunior.mezo_flicker_challenge.common.NO_JSON_CALLBACK
import devanir.soaresjunior.mezo_flicker_challenge.data.net.FlickrService
import devanir.soaresjunior.mezo_flicker_challenge.di.app.AppScope
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @AppScope
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @AppScope
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }

    @Provides
    @AppScope
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor {chain: Interceptor.Chain ->
                // Add the common query parameters
                val url = chain.request().url
                    .newBuilder()
                    .addQueryParameter("api_key", API_KEY)
                    .addQueryParameter("nojsoncallback", NO_JSON_CALLBACK.toString())
                    .addQueryParameter("format", FORMAT)
                    .build()
                val request = chain.request().newBuilder().url(url).build()
                return@addInterceptor chain.proceed(request)
            }
            .connectTimeout(30L, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @AppScope
    fun provideFlickrService(retrofit: Retrofit):FlickrService {
        return retrofit.create(FlickrService::class.java)
    }
}
