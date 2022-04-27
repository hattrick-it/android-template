package com.hattrick.myapplication.presentation.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hattrick.myapplication.presentation.viewmodel.ScreenTwoViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ScreenTwo(stringArgument: String?, navController: NavController) {
    val screenTwoViewModel = getViewModel<ScreenTwoViewModel>()
    val screenTwoState by screenTwoViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Screen two",
                        color = Color.White
                    )
                },
                backgroundColor = Color.Black,
                contentColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, "Icon back")
                    }
                }
            )
        },
        content = {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                if (stringArgument != null) {
                    Text(text = stringArgument, fontSize = 20.sp)
                }
                MagicFun(
                    checked = screenTwoState.isChecked,
                    onCheckedChange = { screenTwoViewModel.toggleButton() }
                )
            }
        }
    )
}

@Composable
fun MagicFun(
    checked: Boolean,
    onCheckedChange: () -> Unit,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = Modifier.width(100.dp),
            text = "Magic",
            fontSize = 20.sp
        )
        Switch(
            checked = checked,
            onCheckedChange = { onCheckedChange() }
        )
    }

    if (checked) {
        HiddenText(color = Color.Red)
    }
}

@Composable
fun HiddenText(color: Color) {
    Text(
        text = "Hello",
        color = color,
        fontSize = 100.sp
    )
}


