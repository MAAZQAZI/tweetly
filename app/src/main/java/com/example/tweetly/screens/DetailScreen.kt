package com.example.tweetly.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetly.models.TweetListItem
import com.example.tweetly.viewmodel.DetailViewModel
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun DetailScreen() {

    val detailViewModel: DetailViewModel = hiltViewModel()
    val tweets = detailViewModel.tweets.collectAsState()
    LazyColumn(content = {
        items(tweets.value.size) {
            TweetItems(tweets.value[it].text ?: "No tweet found")

        }

    })

}


@Composable
fun TweetItems(tweets: String) {

    //make card that shows tweet
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)

    ) {
        //show tweet\
        Text(text = tweets, modifier = Modifier.padding(8.dp))

    }

}