package com.vhuthu.tryout2.di

import com.google.gson.Gson
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.vhuthu.tryout2.data.network.ApiService
import com.vhuthu.tryout2.data.network.OAuthInteceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun providesMoshi(): Moshi =
        Moshi.Builder()
            .run {
                add(KotlinJsonAdapterFactory())
                build()
            }

    @Provides
    @Singleton
    fun providesApiService(moshi: Moshi, okHttpClient: OkHttpClient): ApiService = Retrofit
        .Builder()
        .run {
            baseUrl(ApiService.BASE_URL)
            addConverterFactory(MoshiConverterFactory.create(moshi)) //MoshiConverterFactory.create(moshi)
            client(okHttpClient)
            build()
        }.create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesOKHttpClient(): OkHttpClient {
    val inteceptor = HttpLoggingInterceptor()

        inteceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(
            OAuthInteceptor(
            "Bearer",
            "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aHV0aHVAZ21haWwuY29tIiwicm9sZXMiOiJST0xFX0ZBUk1FUiIsImlhdCI6MTY5MjYyMTc5MiwiZXhwIjoxNjkyNjY0OTkyfQ.MSJbBOqa83BEowC_UnWfpgNiFdB-vEWXI5T8zJmLQBM"
        )
        )
            .addInterceptor(inteceptor)
            .build()
    }



}