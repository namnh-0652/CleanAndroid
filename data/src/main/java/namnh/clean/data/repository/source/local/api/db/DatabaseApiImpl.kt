package namnh.clean.data.repository.source.local.api.db

import namnh.clean.data.repository.source.local.api.DatabaseApi
import namnh.clean.data.repository.source.local.api.db.dao.RepoDao

class DatabaseApiImpl(private val databaseManager: DatabaseManager) : DatabaseApi {

    override fun repoDao(): RepoDao {
        return databaseManager.repoDao()
    }
}
