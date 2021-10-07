package com.example.we8.ui.screens.FirstScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.we8.models.domain.ListItem
import com.example.we8.ui.components.CommunityTileComposable
import com.example.we8.ui.components.FeedSponsorShip
import com.example.we8.ui.theme.We8Theme
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun FirstScreen(navController: NavController,
                viewModel: FirstScreenViewModel = hiltViewModel()
){
    val myList = remember { viewModel.listItems}
    val loading = remember { viewModel.isLoading}
    if(loading.value) {
        Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            CircularProgressIndicator(color = Color.Black)
            Text(text = "loading...")
        }
    } else {
        ListOfItems(myList) {
            val encodedUrl = URLEncoder.encode(it, StandardCharsets.UTF_8.toString())
            navController.navigate("webview/$encodedUrl") }
    }


}

@Composable
fun ListOfItems(myList: SnapshotStateList<ListItem>, navigate: (it: String)-> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 2.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items= myList) { item ->
            when (item) {
                is ListItem.CommunityTileItem ->
                    CommunityTileComposable(item, navigate)
                is ListItem.FeedSponsorShipItem ->
                    FeedSponsorShip(item)
            }
            Spacer(modifier = Modifier.height(10.dp))
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    We8Theme {
        val navController = rememberNavController()
        FirstScreen(navController)
    }
}