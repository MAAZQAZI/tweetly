package com.example.tweetly.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetly.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val tweetRepository: TweetRepository) :
    ViewModel() {
        val category: StateFlow<List<String>>
            get()= tweetRepository.categoryListState

    init {

        viewModelScope.launch {
            tweetRepository.getCategory()
        }
    }
}