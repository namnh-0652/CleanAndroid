package namnh.clean.data.scheduler

import kotlinx.coroutines.Dispatchers
import namnh.clean.domain.scheduler.DispatchersProvider
import kotlin.coroutines.CoroutineContext

class DefaultDispatcher : DispatchersProvider {
    override fun dispatcher(): CoroutineContext {
        return Dispatchers.Default
    }
}