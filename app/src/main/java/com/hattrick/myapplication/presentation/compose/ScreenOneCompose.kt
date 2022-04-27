package com.hattrick.myapplication.presentation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun ScreenOne(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Screen one",
                        color = Color.White
                    )
                },
                backgroundColor = Color.Black,
                contentColor = Color.White
            )
        },
        content = {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(color = Color.White),
                contentAlignment = Alignment.Center
            ) {
                NavigationButton(navController)
            }
        }
    )
}

@Composable
fun NavigationButton(navController: NavController) {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
        onClick = { navController.navigate("screenTwo/Navigating from screen 1") }
    ) {
        Text(
            text ="Go to screen two",
            color = Color.White,
        )
    }
}