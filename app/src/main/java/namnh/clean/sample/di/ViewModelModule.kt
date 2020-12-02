package namnh.clean.sample.di

import namnh.clean.sample.ui.searchrepo.SearchRepoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * You can create your ViewModel with scope, however it is not required because
 * 1 ViewModel can be used by several LifeCycleOwners.
 */
val viewModelModule = module {
    viewModel { SearchRepoViewModel(get(), get()) }
}