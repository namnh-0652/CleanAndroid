package namnh.clean.data.repository.source.local

import namnh.clean.data.repository.source.local.api.DatabaseApi
import namnh.clean.data.repository.source.local.api.SharedPrefApi
import namnh.clean.data.repository.source.local.model.DbRepo

class RepoLocalDataSource(
    private val githubDb: DatabaseApi,
    private val sharedPref: SharedPrefApi
) {
    suspend fun saveRepos(repos: List<DbRepo>) {
        return githubDb.repoDao().save(repos)
    }
}
