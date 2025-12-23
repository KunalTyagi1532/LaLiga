package com.example.laliga2022.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.laliga2022.vm.StandingsViewModel

@Composable
fun TeamDetailScreen(viewModel: StandingsViewModel) {
    val selected = viewModel.selectedTeam.collectAsState().value
    val team = selected.team ?: return

    val goalDifference = team.goalsFor - team.goalsAgainst

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        AsyncImage(
            model = team.logo,
            contentDescription = team.name,
            modifier = Modifier.size(120.dp)
        )

        Text(
            text = team.name,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text("Abbreviation: ${team.abbreviation}")

        Spacer(modifier = Modifier.height(8.dp))

        Text("Rank: ${team.rank}")
        Text("Points: ${team.points}")
        Text("Wins: ${team.wins}")
        Text("Losses: ${team.losses}")
        Text("Draws: ${team.draws}")
        Text("Played: ${team.played}")
        Text("Goals For: ${team.goalsFor}")
        Text("Goals Against: ${team.goalsAgainst}")
        Text("Goal Difference: $goalDifference")
    }
}
