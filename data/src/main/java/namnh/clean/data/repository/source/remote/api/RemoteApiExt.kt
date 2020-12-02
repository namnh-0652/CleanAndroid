package namnh.clean.data.repository.source.remote.api

import namnh.clean.data.repository.source.error.ApiErrorMapper

inline fun <R> GithubApi.execute(block: GithubApi.() -> R): R {
    try {
        return block()
    } catch (throwable: Throwable) {
        throw ApiErrorMapper.map(throwable)
    }
}
