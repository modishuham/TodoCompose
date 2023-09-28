package com.example.todocompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todocompose.ui.theme.BackgroundColor

@Composable
fun DetailScreenMain() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
            .padding(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "Title")
            Text(text = "Description")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    DetailScreenMain()
}