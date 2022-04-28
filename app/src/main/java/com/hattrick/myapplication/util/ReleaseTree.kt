package com.hattrick.myapplication.util

import android.util.Log
import timber.log.Timber

class ReleaseTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        // only pass on log level WARN or ERROR
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return
        }
        if (t == null) {
            //log error to crashlytics
            //Firebase.crashlytics.recordException(Exception(message))
        } else {
            //log error to crashlytics
            //Firebase.crashlytics.recordException(t)
        }
    }
}