package namnh.clean.sample.di

import namnh.clean.sample.model.mapper.OwnerModelMapper
import namnh.clean.sample.model.mapper.RepoModelMapper
import namnh.clean.sample.model.mapper.UserModelMapper
import org.koin.dsl.module

val presentationMapperModule = module {
    factory { UserModelMapper() }
    factory { OwnerModelMapper() }
    factory { RepoModelMapper(get()) }
}
