package namnh.clean.data.repository.source.local.api

import namnh.clean.domain.error.ErrorEntity

sealed class PersistenceError : ErrorEntity() {
    data class DatabaseError(override val originalThrowable: Throwable) : PersistenceError()
    data class FileError(override val originalThrowable: Throwable) : PersistenceError()
    data class SharedPrefError(override val originalThrowable: Throwable) : PersistenceError()
}
