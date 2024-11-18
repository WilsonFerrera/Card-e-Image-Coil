package com.example.cardeimagenes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.example.cardeimagenes.ui.theme.CardEImagenesTheme
import com.example.cardeimagenes.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardEImagenesTheme() {
                Scaffold(
                    topBar = { TopAppComponent() },
                    bottomBar = { BottomBarComponent() },
                    modifier = Modifier.fillMaxSize()
                ) { innerPaddingValues ->
                    Box(modifier = Modifier.padding(innerPaddingValues)) {
                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.verticalScroll(rememberScrollState())
                        ) {
                            val imageUrls = listOf(
                                "https://images.unsplash.com/photo-1601513445498-5dbffc8d5d5a?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                                "https://images.unsplash.com/photo-1729660220527-83a3bba2338d?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                                "https://images.unsplash.com/photo-1602306081673-f26c56e0c0c8?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                                "https://images.unsplash.com/photo-1631856952652-be1d386e1869?q=80&w=1407&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                            )
                            imageUrls.forEach { imageUrl ->
                                ImageCard(imageUrl)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ImageCard(imageUrl: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(8.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppComponent() {
    TopAppBar({ Text(stringResource(R.string.app_name)) })
}

@Composable
fun BottomBarComponent() {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Home, contentDescription = null)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Search, contentDescription = null)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.AddCircle, contentDescription = null)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.PlayArrow, contentDescription = null)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.AccountCircle, contentDescription = null)
            }
        }
    }
}
