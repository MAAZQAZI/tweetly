package com.example.tweetly.api

import com.example.tweetly.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetlyApi {

    @GET("/v3/b/667a6b31e41b4d34e408a9ba?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetListItem>>

    @GET("/v3/b/667a6b31e41b4d34e408a9ba?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategory(): Response<List<String>>
}