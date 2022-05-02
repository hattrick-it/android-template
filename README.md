# android-template

android-template is an implementation of Android Clean Architecture in conjunction with the MVVM
design pattern written in Kotlin using coroutines and flow. There are two implementations of the
Presentation layer, one using XML and Fragments (branch develop) and the other with Jetpack
Compose (branch jetpack_compose_develop).

## Motivation

The objective of the android-template is to speed up the first steps of the development of a new
project and set up a common architecture for all the Hattrick android projects. For that purpose
this project is divided in three modules, each one contains samples:

* Data
    * Data model
    * Api service with Retrofit
    * Room database
    * Repository implementation
* Domain
    * Business logic model
    * Repository interface
    * Custom error
    * Resource success/failure wrapper
    * Use case
* Presentation
    * Jetpack compose
        * Screens using compose functions
        * State handling with ViewModel using stateflow
        * Sample navigation
    * Activity/fragment
        * Base Activity and base Fragment
        * Sample Activity and sample fragments
        * ViewModel with live data
        * Navigation graph
        * Basic XML designs

Additional features

* Timber tree for logs
* Dependency injection with Koin
* All dependencies added in Gradle

Github Actions

* Release and Pull-Request Workflows
* Run Unit Tests and Lint
* Firebase Support
* Semantic Release with Release Notes and Automatic Versioning
* Google Play Deployment
* Slack Notification

## Usage

Fork desired branch (compose or fragments).

Update the name of the project:

* Refactor package com.hattrick.myapplication to desired
* app/build.gradle -> defaultConfig -> applicationId
* strings.xml -> "app_name"
* settings.gradle -> rootProject.name

Github Actions

* App signing and semantic release
  * Place your_keystore.jks under keystores folder in project root folder and upload it
  * Add following github secrets:
      PRODUCTION_STORE_FILE = keystores/your_keystore.jks PRODUCTION_STORE_PASSWORD
      PRODUCTION_KEY_ALIAS PRODUCTION_KEY_PASSWORD
  * Configure your repo to allow the action to create the release and tag
    (Settings->Actions->General->Workflow Permissions->Read and write permissions)
  * Use Angular Commit Message Conventions (suggested tool: commitizen)

* Firebase
  * Add following github secrets:
    FIREBASE_CONFIG 
    
* Slack Notification
  * Generate webhook (https://slack.com/apps/A0F7XDUAZ-incoming-webhooks) and add to secret:
    SLACK_WEBHOOK
    
* Google Play
  * Generate service account json and add to secret:
    SERVICE_ACCOUNT_JSON