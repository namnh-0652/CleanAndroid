package namnh.clean.data.repository.source.local.mapper

import namnh.clean.data.repository.source.local.model.DbRepo
import namnh.clean.domain.entity.Repo

class DbRepoMapper(private val dbOwnerMapper: DbOwnerMapper) {
    fun mapToDomain(input: DbRepo): Repo {
        return Repo(
            id = input.id,
            name = input.name,
            fullName = input.fullName,
            description = input.description.orEmpty(),
            owner = dbOwnerMapper.mapToDomain(input.owner),
            stars = input.stars
        )
    }
}
