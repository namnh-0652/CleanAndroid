package namnh.clean.sample.model.mapper

import namnh.clean.domain.entity.Owner
import namnh.clean.sample.model.OwnerModel

class OwnerModelMapper : PresentationMapper<Owner, OwnerModel>() {

    override fun map(entity: Owner): OwnerModel {
        return OwnerModel(
            id = entity.id,
            login = entity.login,
            url = entity.url
        )
    }
}
