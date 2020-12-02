package namnh.clean.data.repository.source.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NwOwner(
    @Expose @SerializedName("id") val id: Long,
    @Expose @SerializedName("login") val login: String,
    @Expose @SerializedName("url") val url: String?
) : NwData()
