package com.example.network.response

import retrofit2.Response

sealed class Output<out Array> {
    data class Success<Array>(var body: Array) : Output<Array>()
    data class Failure(val errorBody: Error) : Output<Nothing>()
}

fun <R : Any> Response<R>.parseResponse(): Output<R> {
    if (isSuccessful) {
        val body = body()

        if (body != null) {
            return Output.Success(body)
        }
    } else {
        return Output.Failure(Error("Serviço indisponível."))

    }
    return Output.Failure(Error("Serviço indisponível."))
}
