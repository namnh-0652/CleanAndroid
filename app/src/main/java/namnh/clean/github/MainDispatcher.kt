package namnh.clean.github

import kotlinx.coroutines.Dispatchers
import namnh.clean.domain.scheduler.DispatchersProvider
import kotlin.coroutines.CoroutineContext

class MainDispatcher : DispatchersProvider {

    override fun dispatcher(): CoroutineContext {
        return Dispatchers.Main
    }
}
