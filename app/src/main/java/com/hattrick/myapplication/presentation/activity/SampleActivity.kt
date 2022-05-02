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
import com.hattrick.myapplication.util.Arguments
import com.hattrick.myapplication.util.NavRoute

class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = NavRoute.SCREEN_ONE) {
                composable(route = NavRoute.SCREEN_ONE) {
                    ScreenOne(navController)
                }
                composable(
                    route = "${NavRoute.SCREEN_TWO}/{${Arguments.StringArgument}}",
                    arguments = listOf(navArgument(Arguments.StringArgument) {
                        type = NavType.StringType
                    })
                ) {
                    val str = it.arguments?.getString(Arguments.StringArgument)
                    ScreenTwo(str, navController)
                }
            }
        }
    }
}