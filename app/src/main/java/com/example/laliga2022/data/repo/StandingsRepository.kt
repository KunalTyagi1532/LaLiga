package com.example.laliga2022.data.repo

import com.example.laliga2022.data.model.TeamData

interface StandingsRepository {
    suspend fun getStandings(): List<TeamData>
}
