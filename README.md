# MovieManager
Movie Manager is a Kotlin-based application which was used as a training for implementing ViewPager and Retrofit.  
It presents itself as a simple app that consumes the TMDB API and presents the most popular movies.  

# Documentation
[General](#general)  
[Application Behaviour](#application-behaviour)  
[UI Details](#ui-details)  

# General

  -	The application is build base on TDD and MVVM architecture pattern and is using [Android Architecture Components](https://developer.android.com/topic/libraries/architecture)  
  - Using [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) and Databinding for UI implementations
  -	The Application is also using the following libraries: Retrofit, Picasso
  -	Code cleanup for the app has been made using [Sonar Lint](https://www.sonarlint.org/)
  -	Written in Kotlin version : 1.4.10
  -	IDE used is Android Studio version: 4.10
  -	The app minimum requirement is SDK 24


# Application behaviour

 - The application starts and presents the movies. By swiping, the user can discover more popular movies, can see the poster, read the title, description and the rating.
 
# UI Details

 - The application consists of an Activity that supports a Fragment.
     <p align="center">
       <img width="300" alt="Picture 1" src="https://user-images.githubusercontent.com/55602310/95499263-57124100-09a5-11eb-837e-8691aa3e55ab.png">
     </p>
