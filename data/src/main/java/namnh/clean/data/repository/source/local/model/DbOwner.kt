package namnh.clean.data.repository.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    primaryKeys = ["id"],
    tableName = "owner"
)
data class DbOwner(
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "login") val login: String,
    @ColumnInfo(name = "url") val url: String?
) : DbData()
