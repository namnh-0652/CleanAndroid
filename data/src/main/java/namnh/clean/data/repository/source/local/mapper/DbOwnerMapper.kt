package namnh.clean.data.repository.source.local.mapper

import namnh.clean.data.repository.source.local.model.DbOwner
import namnh.clean.domain.entity.Owner

class DbOwnerMapper {
    fun mapToDomain(input: DbOwner): Owner {
        return Owner(
            id = input.id,
            login = input.login,
            url = input.url.orEmpty()
        )
    }
}
