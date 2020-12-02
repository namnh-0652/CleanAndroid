package namnh.clean.data.repository.source.local.api.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import namnh.clean.data.repository.source.local.model.DbRepo

@Dao
abstract class RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun save(repos: List<DbRepo>)
}
