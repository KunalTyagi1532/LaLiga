package com.example.laliga2022.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laliga2022.ui.screens.StandingsScreen
import com.example.laliga2022.ui.screens.TeamDetailScreen
import com.example.laliga2022.vm.StandingsViewModel

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val vm: StandingsViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = "standings"
    ) {
        composable("standings") {
            StandingsScreen(
                viewModel = vm,
                onTeamClick = { team ->
                    vm.select(team)
                    navController.navigate("detail")
                }
            )
        }

        composable("detail") {
            TeamDetailScreen(viewModel = vm)
        }
    }
}
