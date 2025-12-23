package com.example.laliga2022.data.model

data class TeamData(
    val rank: Int,
    val name: String,
    val abbreviation: String,
    val logo: String,

    val points: Int,
    val wins: Int,
    val losses: Int,
    val draws: Int,
    val played: Int,

    val goalsFor: Int,
    val goalsAgainst: Int
)
