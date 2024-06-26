package com.example.tweetly.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetly.models.TweetListItem
import com.example.tweetly.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val tweetRepository: TweetRepository,
    private val saveStateHandle: SavedStateHandle
) :
    ViewModel() {
    val tweets: StateFlow<List<TweetListItem>>
        get()= tweetRepository.tweetListStateFlow

    init {

        viewModelScope.launch {
            val category = saveStateHandle.get<String>("category") ?: "Travel"
            tweetRepository.getTweets(category)
        }
    }
}