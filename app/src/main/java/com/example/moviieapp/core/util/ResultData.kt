package com.example.moviieapp.core.util

sealed class ResultData<out T> {

    object Loading : ResultData<Nothing>()
    data class success<out T>(val data: T?) : ResultData<T>()
    data class Failure(val e: Exception?) : ResultData<Nothing>()

}