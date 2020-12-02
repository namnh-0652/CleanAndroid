package namnh.clean.data.repository.source.error

import java.io.FileNotFoundException
import namnh.clean.data.repository.source.local.api.PersistenceError
import namnh.clean.domain.error.ErrorEntity
import namnh.clean.domain.error.ErrorMapper

object PersistenceErrorMapper : ErrorMapper {
    override fun map(throwable: Throwable): ErrorEntity {
        return when (throwable) {
            is FileNotFoundException, is NoSuchFileException -> PersistenceError.FileError(throwable)
            else -> PersistenceError.DatabaseError(throwable)
        }
    }
}
