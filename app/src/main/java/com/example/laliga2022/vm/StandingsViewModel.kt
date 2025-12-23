package com.example.laliga2022.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laliga2022.data.model.TeamData
import com.example.laliga2022.data.repo.StandingsRepository
import com.example.laliga2022.state.SelectedTeam
import com.example.laliga2022.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val repo: StandingsRepository
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<List<TeamData>>>(UiState.Loading)
    val state: StateFlow<UiState<List<TeamData>>> = _state

    private val _selectedTeam = MutableStateFlow(SelectedTeam(null))
    val selectedTeam: StateFlow<SelectedTeam> = _selectedTeam

    fun load() {
        viewModelScope.launch {
            _state.value = UiState.Loading
            try {
                _state.value = UiState.Success(repo.getStandings())
            } catch (e: Exception) {
                _state.value = UiState.Error(e.message ?: "Error")
            }
        }
    }

    fun select(team: TeamData) {
        _selectedTeam.value = SelectedTeam(team)
    }
}
