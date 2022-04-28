package com.hattrick.myapplication.util

import android.util.Log
import timber.log.Timber

class ReleaseTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return
        }
        if (t == null) {
            //log exception to crashlytics
            //Firebase.crashlytics.recordException(Exception(message))
        } else {
            //log exception to crashlytics
            //Firebase.crashlytics.recordException(t)
        }
    }
}