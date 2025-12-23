package com.example.laliga2022.data.repo

import com.example.laliga2022.data.model.TeamData
import com.example.laliga2022.data.remote.ApiService
import javax.inject.Inject

class StandingsRepositoryImpl @Inject constructor(
    private val api: ApiService
) : StandingsRepository {

    override suspend fun getStandings(): List<TeamData> {
        return api.getStandings().map { dto ->
            TeamData(
                rank = dto.stats?.rank ?: 0,
                name = dto.team?.name ?: "Unknown",
                abbreviation = dto.team?.abbreviation ?: "",
                logo = dto.team?.logo ?: "",
                points = dto.stats?.points ?: 0,
                wins = dto.stats?.wins ?: 0,
                losses = dto.stats?.losses ?: 0,
                draws = dto.stats?.ties ?: 0,
                played = dto.stats?.played ?: 0,
                goalsFor = dto.stats?.goalsFor ?: 0,
                goalsAgainst = dto.stats?.goalsAgainst ?: 0
            )
        }
    }
}
