package com.ac.moviemanager.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ac.moviemanager.R
import com.ac.moviemanager.network.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie.*

private const val baseImagePath = "https://image.tmdb.org/t/p/w500/"

class MovieFragment : Fragment() {

    companion object {
        fun newInstance(movie: Movie): MovieFragment {
            val args = Bundle()
            args.putString("movieTitle", movie.title)
            args.putString("voteAverage", movie.vote_average.toString())
            args.putString("overview", movie.overview)
            args.putString("backdrop_path", movie.poster_path)
            val fragment = MovieFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initFragment()
        super.onViewCreated(view, savedInstanceState)
    }

    //region Helper functions
    private fun initFragment() {
        movie_title_tv_fragment_movies.text = getArgumentsFromIntent("movieTitle")
        overview_tv_movie_fragment.text = getArgumentsFromIntent("overview")
        rating_movie_tv_fragment_movies.text = getArgumentsFromIntent("voteAverage")
        val imagePath = baseImagePath + getArgumentsFromIntent("backdrop_path")

        Picasso.get()
            .load(imagePath)
            .placeholder(R.drawable.placeholder_poster)
            .into(poster_movie_fragment)
    }

    private fun getArgumentsFromIntent(key: String): String? {
        return arguments?.getString(key)
    }
    //endregion

}