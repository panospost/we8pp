package com.example.we8.ui.screens.WebView

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.we8.ui.theme.We8Theme


@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebPageScreen(urlToRender: String?) {
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(urlToRender!!)
        }
    }, update = {
        it.loadUrl(urlToRender!!)
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    We8Theme {
        WebPageScreen("www.google.com")
    }
}