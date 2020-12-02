package namnh.clean.domain.usecase

import namnh.clean.domain.usecase.search.SearchReposUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { SearchReposUseCase(get()) }
}
