package namnh.clean.data.repository

import namnh.clean.data.repository.source.collectionMap
import namnh.clean.data.repository.source.local.RepoLocalDataSource
import namnh.clean.data.repository.source.remote.RepoRemoteDataSource
import namnh.clean.data.repository.source.remote.mapper.NwRepoMapper
import namnh.clean.data.repository.source.remote.model.nullableCollectionMap
import namnh.clean.domain.entity.Repo
import namnh.clean.domain.repository.RepoRepository

class RepoRepositoryImpl(
    private val remoteDataSource: RepoRemoteDataSource,
    private val localDataSource: RepoLocalDataSource,
    private val nwRepoMapper: NwRepoMapper
) : RepoRepository {

    override suspend fun search(query: String, page: Int): List<Repo> {
        val response = remoteDataSource.searchRepos(query = query, page = page)
        val nwRepos = response.items ?: return emptyList()
        val dbRepos = nullableCollectionMap(nwRepos) {
            nwRepoMapper.mapToDb(it)
        }
        if (!dbRepos.isNullOrEmpty()) localDataSource.saveRepos(dbRepos)
        return collectionMap(nwRepos) {
            nwRepoMapper.mapToDomain(it)
        }
    }
}
