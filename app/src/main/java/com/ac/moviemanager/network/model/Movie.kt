package com.ac.moviemanager.network.model

data class Movie(
    var title: String,
    var vote_average: Float,
    var overview: String,
    var poster_path: String
)