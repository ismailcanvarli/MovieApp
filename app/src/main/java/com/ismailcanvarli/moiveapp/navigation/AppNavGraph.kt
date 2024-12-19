//Created by canVarli on 12/19/2024

package com.ismailcanvarli.moiveapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.ismailcanvarli.moiveapp.data.entity.Movie
import com.ismailcanvarli.moiveapp.ui.screen.DetailPage
import com.ismailcanvarli.moiveapp.ui.screen.HomePage

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "homePage") {
        composable("homePage") {
            HomePage(navController = navController)
        }
        composable("detailPage/{movie}", arguments = listOf(navArgument("movie") {
            type = NavType.StringType
        })) {
            val json = it.arguments?.getString("movie")
            val movieInstance = Gson().fromJson(json, Movie::class.java)

            DetailPage(movie = movieInstance)
        } // composable
    } // NavHost
} // AppNavGraph