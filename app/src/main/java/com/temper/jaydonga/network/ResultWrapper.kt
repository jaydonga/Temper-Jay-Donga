package com.temper.jaydonga.network

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T): ResultWrapper<T>()
    data class GenericError(val code: Int? = null, val error: Exception? = null): ResultWrapper<Nothing>()
    object NetworkError: ResultWrapper<Nothing>()
}