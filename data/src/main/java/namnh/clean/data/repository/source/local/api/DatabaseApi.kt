package namnh.clean.data.repository.source.local.api

import namnh.clean.data.repository.source.local.api.db.dao.RepoDao

interface DatabaseApi {
    fun repoDao(): RepoDao
}
