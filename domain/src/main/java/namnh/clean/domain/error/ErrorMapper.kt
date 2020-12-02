package namnh.clean.domain.error

interface ErrorMapper {
    fun map(throwable: Throwable): ErrorEntity
}
