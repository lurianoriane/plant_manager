package com.example.plantmanager.ui.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantmanager.R

@Composable
fun WelcomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp, vertical = 50.dp),
    ) {
        Text(
            text = "Gerencie suas plantas de forma fácil",
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.text_color),
            fontFamily = FontFamily.Default,
            modifier = Modifier.padding(bottom = 50.dp),
        )
    }
    Image(
        painter = painterResource(id = R.drawable.logotype),
        contentDescription = null,
        modifier = Modifier.padding(bottom = 50.dp),
    )
    Text(
        text = "Não esqueça mais de regas suas plantas. Nós cuidamos de lembrar você sempre que precisar.",
        fontSize = 17.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Normal,
        color = colorResource(id = R.color.text_color),
        fontFamily = FontFamily.Default,
        modifier = Modifier.padding(bottom = 50.dp),
    )
    IconButton(onClick = {}) {
        Image(
            painter = painterResource(id = R.drawable.next_icon),
            contentDescription = null,
        )
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}
