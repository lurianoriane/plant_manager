package com.example.plantmanager.ui.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.plantmanager.R

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.splash_screen)),
    ) {
        Image(
            painter = painterResource(id = R.drawable.logotype),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center),
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}
