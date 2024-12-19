//Created by canVarli on 12/19/2024

package com.ismailcanvarli.moiveapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ismailcanvarli.moiveapp.ui.screen.DetailPage
import com.ismailcanvarli.moiveapp.ui.screen.HomePage

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "homePage") {
        composable("homePage") {
            HomePage()
        }
        composable("detailPage") {
            DetailPage()
        }
    }
}