package namnh.clean.data.executor

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import namnh.clean.domain.executor.ThreadExecutor

class JobExecutor : ThreadExecutor {

    private val workQueue = LinkedBlockingQueue<Runnable>()
    private val threadFactory = JobThreadFactory()
    private val threadPoolExecutor = ThreadPoolExecutor(
        CORE_POOL_SIZE,
        MAX_POOL_SIZE,
        KEEP_ALIVE_TIME,
        TimeUnit.SECONDS,
        workQueue,
        threadFactory
    )

    override fun execute(command: Runnable) {
        threadPoolExecutor.execute(command)
    }

    private class JobThreadFactory : ThreadFactory {
        private var counter = 0
        override fun newThread(runnable: Runnable): Thread {
            return Thread(runnable, "$THREAD_NAME${counter++}")
        }

        companion object {
            private const val THREAD_NAME = "clean_thread_"
        }
    }

    companion object {
        private const val CORE_POOL_SIZE = 3
        private const val MAX_POOL_SIZE = 5
        private const val KEEP_ALIVE_TIME = 10L
    }
}
