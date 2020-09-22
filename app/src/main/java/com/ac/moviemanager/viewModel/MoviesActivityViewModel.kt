package com.ac.moviemanager.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ac.moviemanager.network.model.MovieList
import com.ac.moviemanager.repository.MoviesActivityRepository

class MoviesActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val moviesActivityRepository = MoviesActivityRepository(application)
    val movieList: LiveData<MovieList>

    init {
        this.movieList = moviesActivityRepository.moviesList
    }

    fun getMovies() {
        moviesActivityRepository.getMovies()
    }
}