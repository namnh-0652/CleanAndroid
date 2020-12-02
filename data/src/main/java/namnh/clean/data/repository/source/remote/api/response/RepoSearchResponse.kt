package namnh.clean.data.repository.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import namnh.clean.data.repository.source.remote.model.NwRepo

/**
 * Simple object to hold repo search responses. This is different from the Entity in the database
 * because we are keeping a search result in 1 row and denormalizing list of results into a single
 * column.
 */
data class RepoSearchResponse(
    @Expose @SerializedName("total_count") val total: Int = 0,
    @Expose @SerializedName("items") val items: List<NwRepo>?
)
