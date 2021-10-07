package com.example.we8.di

import com.example.we8.api.WeApi
import com.example.we8.repository.AppRepositoryImpl
import com.example.we8.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppRepository(
        api: WeApi
    ) = AppRepositoryImpl(api = api)

    @Singleton
    @Provides
    fun provideAPI(): WeApi {
        val httpClient = OkHttpClient.Builder()

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logging)

        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .client(httpClient.build())
            .build()
            .create(WeApi::class.java)
    }
}