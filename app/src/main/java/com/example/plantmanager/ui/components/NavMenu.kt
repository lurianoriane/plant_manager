package com.example.plantmanager.ui.components

import PlantScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.plantmanager.ui.fragments.MyPlantsScreen
import com.example.plantmanager.ui.viewmodels.MyPlantsUiState
import com.example.plantmanager.ui.viewmodels.PlantUiState

sealed class Screen(val route: String) {
    object MyPlants : Screen("myPlants")
    object NewPlant : Screen("newPlant")
}

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfNavItems = listOf(
    NavItem(label = "Minhas plantas", icon = Icons.Filled.Menu, route = Screen.MyPlants.route),
    NavItem(label = "Nova planta", icon = Icons.Filled.AddCircle, route = Screen.NewPlant.route)
)

@Composable
fun NavBottomBar() {
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
            navController = navController, startDestination = Screen.MyPlants.route,
            Modifier.padding(paddingValues)
        ) {
            // uistate alterado para visualização do preview
            composable(Screen.MyPlants.route) {
                MyPlantsScreen(uiState = listOf(), onPlantClicked = { navController.navigate(Screen.NewPlant.route) })
            }
            composable(Screen.NewPlant.route) {
                PlantScreen(
                    uiState = PlantUiState(),
                    onTimePickerClicked = {},
                    onConfirmClicked = { navController.navigate(Screen.MyPlants.route) })
            }
        }
    }
}
