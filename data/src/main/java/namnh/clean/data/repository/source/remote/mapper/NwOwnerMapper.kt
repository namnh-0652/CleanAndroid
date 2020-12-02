package namnh.clean.data.repository.source.remote.mapper

import namnh.clean.data.repository.source.local.model.DbOwner
import namnh.clean.data.repository.source.remote.model.NwOwner
import namnh.clean.domain.entity.Owner

class NwOwnerMapper {
    fun mapToDomain(nwOwner: NwOwner?): Owner {
        return Owner(
            id = nwOwner?.id ?: 0,
            login = nwOwner?.login.orEmpty(),
            url = nwOwner?.url.orEmpty()
        )
    }

    fun mapToDb(nwOwner: NwOwner?): DbOwner {
        return DbOwner(
            id = nwOwner?.id ?: 0,
            login = nwOwner?.login.orEmpty(),
            url = nwOwner?.url
        )
    }
}
