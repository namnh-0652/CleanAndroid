package namnh.clean.github.model.mapper

import namnh.clean.domain.entity.Repo
import namnh.clean.github.model.RepoModel
import namnh.clean.shared.adapter.RecyclerViewItem

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
