package com.example.plantmanager.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String) {
    object MyPlants : Screen("myplants")
    object PlantScreen : Screen("plantscreen")

}

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfNavItems = listOf(
    NavItem(label = "Minhas plantas", icon = Icons.Filled.Menu, route = Screen.MyPlants.route),
    NavItem(label = "Nova planta", icon = Icons.Filled.AddCircle, route = Screen.PlantScreen.route)
)
