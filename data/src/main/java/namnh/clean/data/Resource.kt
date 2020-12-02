package namnh.clean.data

object Loading : Status()
object Success : Status()
object Error : Status()
sealed class Status

data class Resource<out T>(
    private val status: Status,
    val data: T? = null,
    val throwable: Throwable? = null
) {
    val isLoading = status is Loading
    val isSuccess = status is Success
    val isError = status is Error

    companion object {
        fun <T> success(data: T? = null): Resource<T> {
            return Resource(Success, data)
        }

        fun <T> error(throwable: Throwable?): Resource<T> {
            return Resource(Error, throwable = throwable)
        }

        fun <T> loading(): Resource<T> {
            return Resource(Loading)
        }
    }
}
