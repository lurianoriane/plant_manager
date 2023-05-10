package com.example.plantmanager.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.plantmanager.R

@Composable
fun NextButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.background(color = colorResource(id = R.color.button_color)).size(56.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.next_icon),
            contentDescription = null,
        )
    }
}
