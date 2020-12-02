package namnh.clean.data.repository.source.remote.api.middleware

/*
class TokenAuthenticator(
    private val nonAuthApi: GithubNonAuthApi,
    private val sharedPrefApi: SharedPrefApi,
    private val localBroadcastManager: LocalBroadcastManager
) : Authenticator {

    /**
     * If we've refresh token failed [RETRY_COUNT_LIMIT] times, give it up.
     */
    override fun authenticate(route: Route?, response: Response): Request? {
        Log.i(TAG, "$TAG refresh token is started!")
        if (responseCount(response) >= RETRY_COUNT_LIMIT) {
            Log.i(TAG, "$TAG retried to refresh token but did not working!")
            return null
        }
        val oldTokenInfo = sharedPrefApi.execute {
            get(PREF_TOKEN_INFO, TokenInfo::class.java)
        }
        Log.i(TAG, "$TAG saved token outside sync ${oldTokenInfo?.refreshToken?.token}")
        synchronized(this) {
            // Prevent multiple unnecessary call refresh token
            val syncedTokenInfo = sharedPrefApi.execute {
                get(PREF_TOKEN_INFO, TokenInfo::class.java)
            }
            Log.i(TAG, "$TAG saved token inside sync ${syncedTokenInfo?.refreshToken?.token}")
            if (oldTokenInfo?.refreshToken?.token != null &&
                oldTokenInfo.refreshToken.token != syncedTokenInfo?.refreshToken?.token
            ) {
                // if current refresh token is diff from saved, that mean another refresh has done.
                // we just use the new access token
                Log.i(TAG, "$TAG re-check, synced by other ${syncedTokenInfo?.accessToken?.token}")
                return if (syncedTokenInfo != null) {
                    response.request.newBuilder()
                        .header(
                            AUTHORIZATION,
                            HEADER_REQUEST_TOKEN.plus(syncedTokenInfo.accessToken.token)
                        ).build()
                } else null
            }
            return runBlocking {
                Log.i(TAG, "$TAG refresh token starts in blocking mode !")
                try {
                    val oldRefreshToken = oldTokenInfo?.refreshToken?.token ?: ""
                    val newTokenInfo = nonAuthApi.execute {
                        refreshToken(HEADER_REQUEST_TOKEN.plus(oldRefreshToken))
                    }.data
                    sharedPrefApi.execute {
                        put(PREF_TOKEN_INFO, newTokenInfo)
                        val profile = newTokenInfo.profile
                        put(PREF_PROFILE, profile)
                        if (profile.officeIds?.size == 1) {
                            // If user has only one officeId, we will use it!
                            put(PREF_SELECTED_OFFICE_ID, profile.officeIds[0])
                        }
                    }
                    Log.i(TAG, "$TAG token is refreshed ${newTokenInfo.refreshToken.token}")
                    response.request.newBuilder()
                        .header(
                            AUTHORIZATION,
                            HEADER_REQUEST_TOKEN.plus(newTokenInfo.accessToken.token)
                        ).build()
                } catch (exception: ErrorEntity) {
                    if (exception is ErrorEntity.ApiError.HttpError) {
                        val errorCode =
                            (exception.originalThrowable.cause as? HttpException)?.code()
                        if (errorCode == ERROR_CODE_TOKEN_EXPIRED ||
                            errorCode == ERROR_CODE_INVALID_PARAMETER
                        ) {
                            sharedPrefApi.execute {
                                put(PREF_FLAG_NEW_DEVICE_TOKEN, true)
                                removeKey(PREF_TOKEN_INFO)
                                removeKey(PREF_PROFILE)
                                removeKey(PREF_SELECTED_OFFICE_ID)
                            }
                            localBroadcastManager.sendBroadcast(Intent(ACTION_REFRESH_TOKEN_FAIL))
                        }
                    }
                    null
                }
            }
        }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun responseCount(response: Response): Int {
        var responseMutable = response.priorResponse
        var count = 1
        while (responseMutable != null) {
            count++
            responseMutable = response.priorResponse
        }
        return count
    }

    companion object {
        private const val TAG = "TokenAuthenticator"
        private const val RETRY_COUNT_LIMIT = 3
    }
}
*/
