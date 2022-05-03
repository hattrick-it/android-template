# android-template

* Android Template is a sample implementation of Android Clean Architecture, in conjunction with the MVVM
  design pattern. It’s written in Kotlin, using coroutines and flows for asynchronous code.

* The purpose of this template is to speed up the first stages of development of a new project,
  and establishing a common architecture for all Hattrick’s Android projects.

* There are two versions of the template, using different frameworks for the Presentation layer:
  one with XML and Fragments (branch develop), and the other one with JetpackCompose (branch jetpack_compose_develop).

## Content

### Architecture
The application is divided in three layers, each one in a different module:

* Data (Android Library)
    * Data model
    * Api service with Retrofit
    * Room database
    * Repository implementation

* Domain (Kotlin Library)
    * Business logic model
    * Repository interface
    * Custom error
    * Resource success/failure wrapper
    * Use case

* App (Android App) / (Presentation Layer)
    * Jetpack Compose
        * Screens using compose functions
        * State handling with ViewModel using stateflow
        * Sample navigation
    * Activity/Fragment
        * Base Activity and base Fragment
        * Sample Activity and sample fragments
        * ViewModel with live data
        * Navigation graph
        * Basic XML designs

### Additional features

* Custom Timber Tree for logs
* Dependency injection with Koin

### CI/CD with Github Actions

* Release and Pull-Request Workflows
* Run Unit Tests and Lint
* Firebase Support
* Semantic Release with Release Notes and Automatic Versioning
* Google Play Deployment
* Slack Notification

## Usage

* Fork project’s desired branch (develop or jetpack_compose_develop).

### Naming:

* Refactor package com.hattrick.myapplication to desired package name.
* Update app/build.gradle -> defaultConfig -> applicationId
* Update strings.xml -> "app_name"
* Update settings.gradle -> rootProject.name

### Github Actions:

* App signing and semantic release
    * Place your_keystore.jks under keystores folder in project root folder and upload it
    * Add following github secrets:
    * PRODUCTION_STORE_FILE = keystores/your_keystore.jks
    * PRODUCTION_STORE_PASSWORD
    * PRODUCTION_KEY_ALIAS
    * PRODUCTION_KEY_PASSWORD
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
