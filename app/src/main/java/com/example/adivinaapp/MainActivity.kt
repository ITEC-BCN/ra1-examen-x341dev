package com.example.adivinaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.adivinaapp.view.GameScreen
import com.example.adivinaapp.view.MenuScreen
import com.example.adivinaapp.viewmodels.GameViewModel

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameViewModel: GameViewModel by viewModels()
        setContent {
            NavController(gameViewModel)
        }
    }

    @Composable
    fun NavController(viewModel: GameViewModel) {
        val navigationController = rememberNavController()

        NavHost(
            navController = navigationController,
            startDestination = Routes.Menu.route
        ) {
            composable(Routes.Menu.route) { MenuScreen(navigationController) }
            composable(Routes.Game.route) { GameScreen(viewModel, navigationController) }
        }
    }
}


