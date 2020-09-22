package com.ac.moviemanager.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ac.moviemanager.R
import com.ac.moviemanager.adapter.MoviesPagerAdapter
import com.ac.moviemanager.viewModel.MoviesActivityViewModel
import kotlinx.android.synthetic.main.activity_movies.*

class MoviesActivity : AppCompatActivity() {

    private lateinit var viewModel: MoviesActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        viewModel = ViewModelProvider(this).get(MoviesActivityViewModel::class.java)
        viewModel.getMovies()
        viewModel.movieList.observe(this, {
            view_pager_movies.adapter = MoviesPagerAdapter(supportFragmentManager, it)
            recycler_tab_layout.setUpWithViewPager(view_pager_movies)
        })

    }
}