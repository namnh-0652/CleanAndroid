package namnh.clean.data.repository.source.remote.api.middleware

/*
class AuthInterceptor(private val sharedPrefApi: SharedPrefApi) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequestBuilder = originalRequest.newBuilder()
        // Add Token to header
        val tokenInfo = sharedPrefApi.execute {
            get(SharedPrefKey.PREF_TOKEN_INFO, TokenInfo::class.java)
        }
        tokenInfo?.accessToken?.let { accessToken ->
            newRequestBuilder.addHeader(
                AUTHORIZATION, HEADER_REQUEST_TOKEN.plus(accessToken.token)
            )
        }
        return chain.proceed(newRequestBuilder.build())
    }
}
*/
