package com.example.plantmanager

import PlantScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plantmanager.ui.fragments.MyPlantsScreen
import com.example.plantmanager.ui.components.NavBottomBar
import com.example.plantmanager.ui.fragments.SplashScreen
import com.example.plantmanager.ui.fragments.WelcomeScreen
import com.example.plantmanager.ui.theme.PlantManagerTheme
import com.example.plantmanager.ui.viewmodels.MyPlantsUiState
import com.example.plantmanager.ui.viewmodels.MyPlantsViewModel
import com.example.plantmanager.ui.viewmodels.PlantUiState
import com.example.plantmanager.ui.viewmodels.NewPlantViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlantManagerTheme {
                val navController = rememberNavController()
                NavBottomBar()
                NavHost(
                    navController = navController,
                    startDestination = "splashscreen"
                ) {
                    composable("splashScreen") {
                        SplashScreen(navController = navController)
                    }
                    composable(route = "welcomeScreen") {
                        WelcomeScreen(onNextButtonClicked = { navController.navigate("myPlants") })
                    }
                    composable("myPlants") {
                        val myPlantsViewModel by viewModel<MyPlantsViewModel>()
                        val uiState by myPlantsViewModel.uiState.collectAsState(MyPlantsUiState())
                        // uistate alterado para visualização do preview
                        MyPlantsScreen(uiState = listOf(), onPlantClicked = {
                            navController.navigate("newPlant")
                        })
                    }
                    composable("newPlant") {
                        val scope = rememberCoroutineScope()
                        val viewModel by viewModel<NewPlantViewModel>()
                        val uiState by viewModel.uiState.collectAsState(PlantUiState())
                        PlantScreen(onTimePickerClicked = { /*TODO*/ }, onConfirmClicked = {
                            scope.launch {
                                viewModel.save()
                                navController.navigate("myPlants")
                            }
                        }, uiState = uiState)
                    }

                }
            }

        }
    }
}
