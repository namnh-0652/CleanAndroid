package namnh.clean.data.repository.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index

@Entity(
    indices = [
        Index("id"),
        Index("owner_login")],
    primaryKeys = ["name", "owner_login"],
    tableName = "repo"
)
data class DbRepo(
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "full_name") val fullName: String,
    @ColumnInfo(name = "description") val description: String?,
    @Embedded(prefix = "owner_") val owner: DbOwner,
    @ColumnInfo(name = "stargazers_count") val stars: Int
) : DbData()
