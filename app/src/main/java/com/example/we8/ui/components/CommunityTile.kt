package com.example.we8.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.we8.models.domain.ListItem
import com.example.we8.ui.theme.We8Theme

@Composable
fun CommunityTileComposable(
    communityTile: ListItem.CommunityTileItem,
    navigate: (it: String) -> Unit
) {
    Button(modifier = Modifier.background(Color.White).fillMaxWidth(0.5f),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        onClick = { navigate(communityTile.url) }) {
            Image(
                painter = rememberImagePainter(communityTile.mediaImageUri),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val item = ListItem.CommunityTileItem(
        mediaImageUri = "https=//i-prod.prod.aws.the8app.com/eyJidWNrZXQiOiJwcm9kLXdlYXJlOC1jb21tdW5pdHktdGlsZS1pbWFnZXMiLCJrZXkiOiI1OGFhMzQzYy1kM2U1LTQ2ZjQtYWExZi0wOThhMjMxMWU1NTEtY29tbXVuaXR5LXRpbGUtaW1hZ2UtU3Rhc2hfdGlsZS5wbmcifQ==",
        createdDate = "2020-01-10T14:07:25.9536756Z",
        createdTimestampEpochInMilliseconds = 1578665245954,
        updatedDate = "2020-01-10T19:15L04.1804545Z",
        updatedTimestampEpochInMilliseconds = 1578683704180,
        id = "58aa343c-d3e5-46f4-aa1f-098a2311e551",
        name = "Stash",
        url = "https=//www.weare8.com/stash/",
        categoryType = "community",
        weight = 0
    )
    We8Theme {
        CommunityTileComposable(item, {})
    }
}
