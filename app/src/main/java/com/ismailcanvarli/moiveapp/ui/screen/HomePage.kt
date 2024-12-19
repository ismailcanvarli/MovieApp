//Created by canVarli on 12/19/2024

package com.ismailcanvarli.moiveapp.ui.screen

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.ismailcanvarli.moiveapp.data.entity.Movie
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController) {
    val movieList = remember { mutableStateListOf<Movie>() }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        val f1 = Movie(1, "Django", "django", 24)
        val f2 = Movie(2, "Interstellar", "interstellar", 32)
        val f3 = Movie(3, "Inception", "inception", 16)
        val f4 = Movie(4, "The Hateful Eight", "thehatefuleight", 28)
        val f5 = Movie(5, "The Pianist", "thepianist", 18)
        val f6 = Movie(6, "Anadoluda", "anadoluda", 10)
        movieList.add(f1)
        movieList.add(f2)
        movieList.add(f3)
        movieList.add(f4)
        movieList.add(f5)
        movieList.add(f6)
    }

    Scaffold(topBar = { TopAppBar(title = { Text(text = "Movie") }) }, snackbarHost = {
        SnackbarHost(snackbarHostState)
    }) { paddingValues ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues), columns = GridCells.Fixed(2)
        ) {
            items(count = movieList.count(), itemContent = {
                val movie = movieList[it]
                Card(modifier = Modifier.padding(5.dp)) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            val movieJson = Gson().toJson(movie)
                            navController.navigate("detailPage/${movieJson}")
                        }) {
                        val activity = LocalContext.current as Activity
                        Image(
                            painter = painterResource(
                                id = activity.resources.getIdentifier(
                                    movie.picture, "drawable", activity.packageName
                                )
                            ), contentDescription = " ", modifier = Modifier.size(200.dp, 300.dp)
                        ) // Image

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(text = "${movie.price} TL", fontSize = 24.sp)

                            Button(onClick = {
                                scope.launch {
                                    snackbarHostState.showSnackbar("${movie.name} added to cart")
                                }
                            }) {
                                Text(text = "Add to Cart")
                            } // Button
                        } // Row
                    } // Column
                } // Card
            } // itemContent
            ) // items
        } // LazyVerticalGrid
    } // Scaffold
} // HomePage