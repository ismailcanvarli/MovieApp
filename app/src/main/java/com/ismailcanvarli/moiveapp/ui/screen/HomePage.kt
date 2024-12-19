//Created by canVarli on 12/19/2024

package com.ismailcanvarli.moiveapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.ismailcanvarli.moiveapp.data.entity.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {
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

    Scaffold(topBar = { TopAppBar(title = { Text(text = "Movie") }) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

        }
    }
}