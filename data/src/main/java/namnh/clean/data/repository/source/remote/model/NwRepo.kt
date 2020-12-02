package namnh.clean.data.repository.source.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NwRepo(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String?,
    @Expose @SerializedName("full_name") val fullName: String?,
    @Expose @SerializedName("description") val description: String?,
    @Expose @SerializedName("owner") val nwOwner: NwOwner?,
    @Expose @SerializedName("stargazers_count") val stars: Int?
) : NwData()
