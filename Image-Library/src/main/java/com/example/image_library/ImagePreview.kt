package com.example.image_library

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun ImagePreview(
    Image: Painter,
    modifier: Modifier = Modifier,
    description: String? = "",
    contentDescription: String? = "",
    onImageClick: () -> Unit = {}

) {
    Box(modifier = modifier
        .aspectRatio(1f)
        .clip(shape = RoundedCornerShape(8.dp))
        .shadow(4.dp)
        .clickable { onImageClick() }) {

        Image(painter = Image , contentDescription = contentDescription, contentScale = ContentScale.Crop)
    }

}