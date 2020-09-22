package com.ac.moviemanager.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.ac.moviemanager.network.API_KEY
import com.ac.moviemanager.network.BASE_URL
import com.ac.moviemanager.network.MovieNetwork
import com.ac.moviemanager.network.RetrofitBuilder
import com.ac.moviemanager.network.model.MovieList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesActivityRepository(val application: Application) {

    val moviesList = MutableLiveData<MovieList>()

    fun getMovies() {
        val retrofit = RetrofitBuilder.initRetrofitCall(BASE_URL)
        val service = retrofit.create(MovieNetwork::class.java)
        service.getMovies(API_KEY).enqueue(object : Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                if (response.isSuccessful) {
                    moviesList.value = response.body()
                    Log.println(Log.INFO, "ResponseMovies", "Success!")
                } else {
                    Toast.makeText(
                        application.applicationContext,
                        "Error getting movies!",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.println(Log.ERROR, "ResponseMovies:", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                Toast.makeText(
                    application.applicationContext,
                    "Error getting movies!",
                    Toast.LENGTH_SHORT
                ).show()
                Log.println(Log.ERROR, "FailureMovies:", t.stackTraceToString())
            }

        })
    }
}