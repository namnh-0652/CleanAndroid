package namnh.clean.domain.error

abstract class ErrorEntity : Throwable() {
    abstract val originalThrowable: Throwable

    // Other error or group kind of error
}
