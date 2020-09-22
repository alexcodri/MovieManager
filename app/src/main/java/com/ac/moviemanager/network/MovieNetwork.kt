package com.ac.moviemanager.network

import com.ac.moviemanager.network.model.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL = "https://api.themoviedb.org/3/movie/"
const val API_KEY = "c8e47c043cfd9af9a7ae1cbb6f2a135f"

interface MovieNetwork {

    @GET("popular?")
    fun getMovies(@Query("api_key") apiKey: String): Call<MovieList>

}