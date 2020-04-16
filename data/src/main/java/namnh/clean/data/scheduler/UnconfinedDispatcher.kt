package namnh.clean.data.scheduler

import kotlinx.coroutines.Dispatchers
import namnh.clean.domain.scheduler.DispatchersProvider
import kotlin.coroutines.CoroutineContext

class UnconfinedDispatcher : DispatchersProvider {
    override fun dispatcher(): CoroutineContext {
        return Dispatchers.Unconfined
    }
}