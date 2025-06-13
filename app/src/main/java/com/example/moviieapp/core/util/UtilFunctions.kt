package com.example.moviieapp.core.util

import timber.log.Timber

object UtilFunctions {

    fun logError(tag: String, message: String) {
        Timber.tag(tag).e("error -> $message")
    }

    fun logInfo(tag: String, message: String) {
        Timber.tag(tag).i("info -> $message")
    }

}