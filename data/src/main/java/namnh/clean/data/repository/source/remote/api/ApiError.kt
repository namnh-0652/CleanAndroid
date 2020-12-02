package namnh.clean.data.repository.source.remote.api

import namnh.clean.domain.error.ErrorEntity

sealed class ApiError : ErrorEntity() {
    data class HttpError(override val originalThrowable: Throwable) : ApiError()
    data class ServerError(override val originalThrowable: Throwable) : ApiError()
    data class NetworkError(override val originalThrowable: Throwable) : ApiError()
    data class UnexpectedError(override val originalThrowable: Throwable) : ApiError()
}
