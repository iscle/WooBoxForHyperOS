package com.github.iscle.wooboxforhyperos.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.iscle.wooboxforhyperos.ui.component.SwitchPreference

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "WooBox",
                    )
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            stickyHeader {
                Text(
                    text = "General",
                    modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.labelLarge
                )
            }

            item {
                SwitchPreference(
                    text = "Main switch",
                    checked = true,
                    onCheckedChange = {},
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            stickyHeader {
                Text(
                    text = "Scope",
                    modifier = Modifier.fillMaxSize()
                )
            }

            item {
                Text(
                    text = "Hello, World!",
                    modifier = Modifier.fillMaxSize()
                )
            }

            stickyHeader {
                Text(
                    text = "About",
                    modifier = Modifier.fillMaxSize()
                )
            }

            item {
                Text(
                    text = "WooBox is a sample app for HyperOS.",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}