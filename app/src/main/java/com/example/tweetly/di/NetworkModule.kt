package com.example.tweetly.di

import com.example.tweetly.api.TweetlyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providerRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io/").addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideTweetlyApi(retrofit: Retrofit): TweetlyApi {
        return retrofit.create(TweetlyApi::class.java)
    }
}