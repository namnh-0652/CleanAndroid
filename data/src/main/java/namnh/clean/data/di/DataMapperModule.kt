package namnh.clean.data.di

import namnh.clean.data.repository.source.local.mapper.DbOwnerMapper
import namnh.clean.data.repository.source.local.mapper.DbRepoMapper
import namnh.clean.data.repository.source.remote.mapper.NwOwnerMapper
import namnh.clean.data.repository.source.remote.mapper.NwRepoMapper
import org.koin.dsl.module

val dataMapperModule = module {
    factory { DbOwnerMapper() }
    factory { DbRepoMapper(get()) }
    factory { NwOwnerMapper() }
    factory { NwRepoMapper(get()) }
}
