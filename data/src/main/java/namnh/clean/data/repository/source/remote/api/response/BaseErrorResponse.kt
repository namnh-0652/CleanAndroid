package namnh.clean.data.repository.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseErrorResponse(
    @Expose @SerializedName("code") val code: Int,
    @Expose @SerializedName("message") val message: String?,
    @Expose @SerializedName("errors") val errors: List<Error>?
) {
    data class Error(
        @Expose @SerializedName("key") val key: String?,
        @Expose @SerializedName("errorCode") val errorCode: Int?,
        @Expose @SerializedName("message") val message: String?
    )
}
