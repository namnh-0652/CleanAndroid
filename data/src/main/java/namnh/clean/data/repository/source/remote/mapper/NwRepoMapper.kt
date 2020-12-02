package namnh.clean.data.repository.source.remote.mapper

import namnh.clean.data.repository.source.local.model.DbRepo
import namnh.clean.data.repository.source.remote.model.NwRepo
import namnh.clean.domain.entity.Repo

class NwRepoMapper(private val nwOwnerMapper: NwOwnerMapper) {

    fun mapToDomain(nwRepo: NwRepo): Repo {
        return Repo(
            id = nwRepo.id,
            name = nwRepo.name.orEmpty(),
            fullName = nwRepo.fullName.orEmpty(),
            description = nwRepo.description.orEmpty(),
            owner = nwOwnerMapper.mapToDomain(nwRepo.nwOwner),
            stars = nwRepo.stars ?: 0
        )
    }

    fun mapToDb(nwRepo: NwRepo): DbRepo {
        return DbRepo(
            id = nwRepo.id,
            name = nwRepo.name.orEmpty(),
            fullName = nwRepo.fullName.orEmpty(),
            description = nwRepo.description,
            owner = nwOwnerMapper.mapToDb(nwRepo.nwOwner),
            stars = nwRepo.stars ?: 0
        )
    }
}
