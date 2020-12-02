package namnh.clean.sample.model.mapper

import namnh.clean.domain.entity.Repo
import namnh.clean.sample.model.RepoModel

class RepoModelMapper(private val ownerMapper: OwnerModelMapper) :
    PresentationMapper<Repo, RepoModel>() {

    override fun map(entity: Repo): RepoModel {
        return RepoModel(
            id = entity.id,
            name = entity.name,
            fullName = entity.fullName,
            description = entity.description,
            owner = ownerMapper.map(entity.owner),
            stars = entity.stars
        )
    }
}
