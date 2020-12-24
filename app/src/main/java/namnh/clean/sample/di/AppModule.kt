package namnh.clean.sample.di

import namnh.clean.data.dispatcher.DefaultDispatcher
import namnh.clean.data.dispatcher.IODispatcher
import namnh.clean.domain.scheduler.DEFAULT
import namnh.clean.domain.scheduler.DispatchersProvider
import namnh.clean.domain.scheduler.IO
import namnh.clean.domain.scheduler.MAIN
import namnh.clean.sample.MainDispatcher
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single<DispatchersProvider>(named(IO)) { IODispatcher() }
    single<DispatchersProvider>(named(DEFAULT)) { DefaultDispatcher() }
    single<DispatchersProvider>(named(MAIN)) { MainDispatcher() }
}
