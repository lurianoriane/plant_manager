package com.example.plantmanager.ui.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun WelcomeScreen(onNextButtonClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.background_color))
            .padding(horizontal = 30.dp, vertical = 20.dp)
            .fillMaxSize(), verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.welcome_text),
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.text_color),
            fontFamily = FontFamily.Default,
            modifier = Modifier
                .padding(bottom = 30.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.welcome_image),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 30.dp)
                .fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.dont_forget_text),
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.text_color),
            fontFamily = FontFamily.Default,
            modifier = Modifier
                .padding(bottom = 30.dp)
                .fillMaxWidth(),
        )
        IconButton(onClick = { onNextButtonClicked() }, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.next_button),
                contentDescription = stringResource(R.string.next_button_description),
            )
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(onNextButtonClicked = {})
}
