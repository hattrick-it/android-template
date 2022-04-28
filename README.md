# android-template
android-template is an implementation of Android Clean Architecture in conjunction with the MVVM design pattern written in Kotlin using corutines and flow. There are two implementations of the Presentation layer, one using XML and Fragments (branch develop) and the other with Jetpack Compose (branch jetpack_compose_develop). 

## Motivation
The objetive of the android-template is to speed up the first steps of the development of a new project and set up a common architecture for all the Hattrick android projects.
For that purpose this project is divided in three modules, each one contains samples:
* Data
  * Data model
  * Api service with Retrofit
  * Room database
  * Repository implementation
* Domain
  * Business logic model
  * Repository interface
  * Custom error
  * Resource succes/failure wraper
  * Use case
* Presentation
  * Jetpack compose
    * Screens using compose functions
    * State handling with ViewModel using stateflow
    * Sample navigation
  * Activity/fragment
    * Base Activit and base Fragment
    * Sample Activity and sample fragments
    * ViewModel with live data
    * Navigation graph
    * Basic XML designs
  
Additional features
  * Timber tree for logs
  * Dependency injection with Koin
  * All dependencies added in Graddle
