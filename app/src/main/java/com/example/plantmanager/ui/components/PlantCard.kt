package com.example.plantmanager.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantmanager.R
import com.example.plantmanager.model.PlantModel

@Composable
fun PlantCard(plant: PlantModel, onPlantClicked: () -> Unit, modifier: Modifier = Modifier) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.background_color))
            .clickable { onPlantClicked() },

        ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                contentDescription = null,
                modifier = modifier
                    .height(100.dp),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentScale = ContentScale.Crop
            )

            Text(
                text = plant.name,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.text_color),
                fontFamily = FontFamily.Default,
            )
        }
    }
}

@Preview
@Composable
fun PlantCardPreview() {
    val planta = PlantModel(
        id = 1,
        name = "Peperomia",
        place = "Sala",
        waterHour = 1L,
        water = true,
        image = R.drawable.plant_image
    )
    PlantCard(plant = planta, onPlantClicked = { /*TODO*/ })
}




