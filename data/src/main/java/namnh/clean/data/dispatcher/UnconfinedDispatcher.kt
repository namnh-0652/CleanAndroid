package namnh.clean.data.dispatcher

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import namnh.clean.domain.scheduler.DispatchersProvider

class UnconfinedDispatcher : DispatchersProvider {
    override fun dispatcher(): CoroutineContext {
        return Dispatchers.Unconfined
    }
}
