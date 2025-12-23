La Liga 2022 Standings App
Overview

Android application that displays the final La Liga 2022 league standings using a static, pre-sorted API response.
Data is treated as historical and read-only and is displayed exactly as received.

Built using MVVM architecture, Jetpack Compose, and Dagger Hilt.

Features

Standings table displaying all teams

Each row shows:

Rank

Team logo

Team name

Games played

Goal difference

Points

Rank-based row styling:

1: Gold

2–4: Blue

5: Orange

6: Light Green

7–20: Default

Team detail screen with complete statistics

Read-only UI

Architecture

UI: Jetpack Compose, observes ViewModel state, handles navigation

ViewModel: Exposes UI state and selected team

Repository: Fetches and maps API data

Network: Retrofit + OkHttp with RapidAPI headers

UI State Handling

Loading indicator

Success state (standings table)

Error state with retry option

How to Run

Open project in Android Studio

Add RapidAPI key in NetworkModule

Sync Gradle and run the app