package namnh.clean.data.repository.source.error

import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import java.io.IOException
import namnh.clean.data.repository.source.remote.api.ApiError
import namnh.clean.data.repository.source.remote.api.response.BaseErrorResponse
import namnh.clean.domain.error.ErrorEntity
import namnh.clean.domain.error.ErrorMapper
import retrofit2.HttpException

object ApiErrorMapper : ErrorMapper {
    private const val SERVER_ERROR_CODE = 500

    override fun map(throwable: Throwable): ErrorEntity {
        return when (throwable) {
            is HttpException -> {
                val errorBody = throwable.response()?.errorBody()
                if (errorBody != null) {
                    val errorResponse = deserializeServerError(errorBody.string())
                    return if (errorResponse != null &&
                        errorResponse.code >= SERVER_ERROR_CODE ||
                        throwable.code() >= SERVER_ERROR_CODE
                    ) {
                        // Service downs
                        toServerError(Throwable(errorResponse?.message, throwable))
                    } else {
                        toHttpError(Throwable(errorResponse?.message, throwable))
                    }
                }
                // This should not be happened, in this case we leave it as an unexpected error
                return toUnexpectedError(throwable)
            }
            is IOException -> toNetworkError(throwable)
            else -> toUnexpectedError(throwable)
        }
    }

    fun getErrorMessage(throwable: Throwable): String {
        if (throwable !is HttpException) return ""
        val response = throwable.response()
        val errorBody = response?.errorBody() ?: return ""
        try {
            val errorResponse = errorBody.string()
            deserializeServerError(errorResponse) ?: return response.message()
        } catch (ignored: IOException) {
        }
        return ""
    }

    fun getErrorCode(throwable: Throwable?): Int {
        if (throwable !is HttpException) return INVALID_ERROR_CODE
        return throwable.response()?.code() ?: INVALID_ERROR_CODE
    }

    private fun deserializeServerError(errorString: String): BaseErrorResponse? {
        val gson = GsonBuilder().create()
        return try {
            gson.fromJson(errorString, BaseErrorResponse::class.java)
        } catch (e: JsonSyntaxException) {
            null
        }
    }

    private fun toHttpError(throwable: Throwable): ApiError.HttpError {
        return ApiError.HttpError(originalThrowable = throwable)
    }

    private fun toServerError(throwable: Throwable): ApiError.ServerError {
        return ApiError.ServerError(originalThrowable = throwable)
    }

    private fun toUnexpectedError(throwable: Throwable): ApiError.UnexpectedError {
        return ApiError.UnexpectedError(originalThrowable = throwable)
    }

    private fun toNetworkError(throwable: Throwable): ApiError.NetworkError {
        return ApiError.NetworkError(originalThrowable = throwable)
    }
}
