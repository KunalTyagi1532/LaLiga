package com.example.laliga2022.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.laliga2022.data.model.TeamData
import com.example.laliga2022.state.UiState
import com.example.laliga2022.ui.components.StandingsRow
import com.example.laliga2022.vm.StandingsViewModel

@Composable
fun StandingsScreen(
    viewModel: StandingsViewModel,
    onTeamClick: (TeamData) -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.load()
    }

    val state = viewModel.state.collectAsState().value

    when (state) {

        is UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is UiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = state.message)
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(onClick = { viewModel.load() }) {
                        Text("Retry")
                    }
                }
            }
        }

        is UiState.Success -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {

                item {
                    Text(
                        text = "La Liga 2022 Standings",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                items(state.data) { team ->
                    StandingsRow(
                        team = team,
                        onClick = onTeamClick
                    )
                }
            }
        }
    }
}
