//Created by canVarli on 12/19/2024

package com.ismailcanvarli.moiveapp.ui.screen

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ismailcanvarli.moiveapp.data.entity.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPage(movie: Movie) {
    Scaffold(topBar = { TopAppBar(title = { Text(text = movie.name) }) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val activity = (LocalContext.current as Activity)
            Image(
                bitmap = ImageBitmap.imageResource(
                    id = activity.resources.getIdentifier(
                        movie.picture, "drawable", activity.packageName
                    )
                ), contentDescription = "", modifier = Modifier.size(200.dp, 300.dp)
            )
            Text(text = "${movie.price} $", fontSize = 50.sp)
        } // Column
    } // Scaffold
} // DetailPage