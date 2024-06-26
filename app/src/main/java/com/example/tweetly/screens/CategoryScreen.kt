package com.example.tweetly.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetly.R
import com.example.tweetly.viewmodel.CategoryViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun CategoryScreen(onClick: (category: String) -> Unit) {
    val categoryViewModel: CategoryViewModel = hiltViewModel()
    val categoryList = categoryViewModel.category.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        items(categoryList.value.distinct()) {
            CategoryItem(category = it, onClick)
        }
    }
}


@Composable
fun CategoryItem(category: String , onClick: (category:String) -> Unit) {

    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.LightGray).clickable { onClick(category) }
            .size(88.dp)
            .paint(painter = painterResource(id = R.drawable.bg), contentScale = ContentScale.Crop)
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, color = Color(0xFFEEEEEE)), contentAlignment = Alignment.BottomCenter
    ) {

        Text(
            text = category,
            modifier = Modifier
                .padding(0.dp, 20.dp), fontSize = 18.sp, style = MaterialTheme.typography.bodyMedium
        )

    }
}