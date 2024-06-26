package com.example.tweetly.repository

import com.example.tweetly.api.TweetlyApi
import com.example.tweetly.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetlyApi: TweetlyApi){

    private val category= MutableStateFlow<List<String>>(emptyList())
    val categoryListState :StateFlow<List<String>> //stateflow<<>>
        get() = category

    private val tweetList = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweetListStateFlow : StateFlow<List<TweetListItem>>
        get() = tweetList


    suspend fun getTweets(category: String){
        var response = tweetlyApi.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null){
            tweetList.emit(response.body()!!)
        }

    }

    suspend fun getCategory(){
        var response = tweetlyApi.getCategory()
        if (response.isSuccessful && response.body() != null){

                category.emit(response.body()!!)

        }
    }
}