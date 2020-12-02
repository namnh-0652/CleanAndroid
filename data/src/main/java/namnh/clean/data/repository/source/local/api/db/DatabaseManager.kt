package namnh.clean.data.repository.source.local.api.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import namnh.clean.data.repository.source.local.DatabaseConfig
import namnh.clean.data.repository.source.local.api.db.dao.RepoDao
import namnh.clean.data.repository.source.local.model.DbRepo

@Database(
    entities = [DbRepo::class],
    version = DatabaseConfig.DB_VERSION
)
@TypeConverters(/*Add converters here.*/)
abstract class DatabaseManager : RoomDatabase() {
    abstract fun repoDao(): RepoDao
}
