package com.example.plantmanager

import PlantScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.plantmanager.ui.components.listOfNavItems
import com.example.plantmanager.ui.fragments.MyPlantsScreen
import com.example.plantmanager.ui.fragments.SplashScreen
import com.example.plantmanager.ui.fragments.WelcomeScreen
import com.example.plantmanager.ui.theme.PlantManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlantManagerTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            listOfNavItems.forEach { navItem ->
                                NavigationBarItem(
                                    selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                                    onClick = {
                                        navController.navigate(navItem.route) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = { Icon(imageVector = navItem.icon, contentDescription = null) },
                                    label = {
                                        Text(text = navItem.label)
                                    }
                                )
                            }
                        }
                    }
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = "splashscreen",
                        Modifier.padding(paddingValues)
                    ) {
                        composable("splashscreen") {
                            SplashScreen(navController = navController)
                        }
                        composable(route = "welcomescreen") {
                            WelcomeScreen(onNextButtonClicked = { navController.navigate("myplants") })
                        }
                        composable("myplants") {
                            MyPlantsScreen(onPlantClicked = {
                                navController.navigate("plantscreen")
                            })
                        }
                        composable("plantscreen") {
                            PlantScreen(
                                onTimePickerClicked = { /*TODO*/ },
                                onConfirmClicked = { navController.navigate("myplants") }
                            )
                        }

                    }

                }
            }
        }
    }
}