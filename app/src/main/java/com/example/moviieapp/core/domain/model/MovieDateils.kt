package com.example.moviieapp.core.domain.model

import kotlin.time.Duration

data class MovieDateils(
    val id: Int,
    val title: String,
    val genres: List<String>,
    val backdropPathUrl: String?,
    val realseDate: String?,
    val overview: String?,
    val voteAverage: Double,
    val duration: Int = 0,
    val vouteCount: Int = 0,
)
