package com.hattrick.myapplication.presentation.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hattrick.myapplication.presentation.compose.ScreenOne
import com.hattrick.myapplication.presentation.compose.ScreenTwo

class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "screenOne") {
                composable(route = "screenOne") {
                    ScreenOne(navController)
                }
                composable(
                    route = "screenTwo/{stringArgument}",
                    arguments = listOf(navArgument("stringArgument") {
                        type = NavType.StringType
                    })
                ) {
                    val str = it.arguments?.getString("stringArgument")
                    ScreenTwo(str, navController)
                }
            }
        }
    }
}