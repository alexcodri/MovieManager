package com.ac.moviemanager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ac.moviemanager.network.model.MovieList
import com.ac.moviemanager.view.MovieFragment

class MoviesPagerAdapter(
    fragmentManager: FragmentManager,
    private val movies: MovieList
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return movies.results.size
    }

    override fun getItem(position: Int): Fragment {
        return MovieFragment.newInstance(movies.results[position])
    }

    override fun getPageTitle(position: Int): CharSequence {
        return movies.results[position].title
    }
}