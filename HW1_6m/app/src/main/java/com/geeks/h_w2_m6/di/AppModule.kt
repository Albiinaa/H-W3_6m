package com.geeks.h_w2_m6.di
import com.geeks.h_w2_m6.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://rickandmortyapi.com/api"
    private const val TIMEOUT = 10L
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
    @Provides
    fun provideOkhttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient{
        return OkHttpClient.Builder()
            .connectTimeout(TIMEOUT,TimeUnit.SECONDS)
            .readTimeout(TIMEOUT,TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT,TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }
    @Provides
    fun provideHttpInterceptor(): HttpLoggingInterceptor {
      return HttpLoggingInterceptor().apply {
          level = HttpLoggingInterceptor.Level.BODY
      }
    }

    @Provides
    fun provideApiService(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }
}