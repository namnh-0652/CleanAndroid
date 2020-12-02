package namnh.clean.data.repository.source.local.api

import namnh.clean.data.repository.source.error.PersistenceErrorMapper

inline fun <R> DatabaseApi.execute(block: DatabaseApi.() -> R): R {
    try {
        return block()
    } catch (throwable: Throwable) {
        throw PersistenceErrorMapper.map(throwable)
    }
}

inline fun <R> SharedPrefApi.execute(block: SharedPrefApi.() -> R): R {
    try {
        return block()
    } catch (throwable: Throwable) {
        throw PersistenceErrorMapper.map(throwable)
    }
}
