package com.example.plantmanager.ui.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantmanager.R
import com.example.plantmanager.model.PlantModel
import com.example.plantmanager.ui.components.PlantCard

//ui state alterado para visualização do preview
@Composable
fun MyPlantsScreen(uiState: List<PlantModel>, onPlantClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        HeaderComponent()
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier

        ) {
            Text(
                text = stringResource(R.string.next_plants_text),
                fontSize = 24.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.text_color),
                fontFamily = FontFamily.Default,
            )
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(
                items = uiState,
                itemContent = {
                    PlantCard(
                        plant = uiState[it.id],
                        onPlantClicked = { onPlantClicked() }
                    )
                }
            )
        }
    }
}

@Composable
fun HeaderComponent() {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Minhas",
                fontSize = 32.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.text_color),
                fontFamily = FontFamily.Default,
            )
            Text(
                text = "Plantinhas",
                fontSize = 32.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.text_color),
                fontFamily = FontFamily.Default,
            )
        }
        Column() {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "foto do avatar",
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyPlantsScreenPreview() {
    MyPlantsScreen(uiState = createList(), onPlantClicked = {})
}


fun createList(): List<PlantModel> {
    val plantList = mutableListOf<PlantModel>()
    for (i in 1..6) {
        plantList.add(
            PlantModel(
                id = i,
                name = "Planta",
                place = "Sala",
                water = false,
                waterHour = 1230,
                image = R.drawable.plant_image
            )
        )
    }
    return plantList
}