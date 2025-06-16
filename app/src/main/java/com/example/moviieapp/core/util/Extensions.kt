package com.example.moviieapp.core.util

import com.example.moviieapp.BuildConfig

fun String?.toPostUrl() = "${BuildConfig.BASE_URL_IMAGE}$this"
fun String?.toBackdropUrl() = "${BuildConfig.BASE_URL_IMAGE}$this"