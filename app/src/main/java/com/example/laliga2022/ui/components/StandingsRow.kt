package com.example.laliga2022.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.laliga2022.data.model.TeamData

@Composable
fun StandingsRow(
    team: TeamData,
    onClick: (TeamData) -> Unit
) {
    val rowColor = when (team.rank) {
        1 -> Color(0xFFFFD700)      // Gold
        2, 3, 4 -> Color(0xFF90CAF9) // Light Blue
        5 -> Color(0xFFFFB74D)      // Orange
        6 -> Color(0xFFA5D6A7)      // Light Green
        else -> Color(0xFFF5F5F5)   // Light gray (default rows)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .clickable { onClick(team) },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = rowColor
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = team.rank.toString(),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.width(24.dp)
            )

            Spacer(Modifier.width(12.dp))

            AsyncImage(
                model = team.logo,
                contentDescription = team.name,
                modifier = Modifier.size(36.dp)
            )

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = team.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "P ${team.played}  GD ${team.goalsFor - team.goalsAgainst}",
                    style = MaterialTheme.typography.labelSmall
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "${team.points}",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "pts",
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}
