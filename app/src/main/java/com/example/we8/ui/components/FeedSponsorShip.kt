package com.example.we8.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.we8.models.domain.ListItem

@Composable
fun FeedSponsorShip (
    feedSponsorShip: ListItem.FeedSponsorShipItem
){

    Button(modifier = Modifier.background(Color.White).fillMaxWidth(0.5f),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        onClick = { }) {
        Image(
            painter = rememberImagePainter(feedSponsorShip.coverTileUri),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
    }
}