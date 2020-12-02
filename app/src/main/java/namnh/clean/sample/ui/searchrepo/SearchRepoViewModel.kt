package namnh.clean.sample.ui.searchrepo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import java.util.*
import kotlinx.coroutines.launch
import namnh.clean.data.Resource
import namnh.clean.domain.usecase.search.SearchReposUseCase
import namnh.clean.sample.model.mapper.RepoModelMapper
import namnh.clean.sample.ui.base.BaseViewModel
import namnh.clean.sample.ui.searchrepo.adapter.SearchRepoItem
import namnh.clean.shared.adapter.RecyclerViewItem
import namnh.clean.shared.livedata.AbsentLiveData

class SearchRepoViewModel(
    private val searchReposUseCase: SearchReposUseCase,
    private val repoModelMapper: RepoModelMapper
) : BaseViewModel() {

    private val query = MutableLiveData<String>()
    private val nextPage = MutableLiveData<Int?>().apply { value = 1 }
    val results: LiveData<Resource<List<RecyclerViewItem>?>> = Transformations
        .switchMap(query) { search ->
            if (search.isNullOrBlank()) {
                AbsentLiveData.create()
            } else {
                searchRepo(search, nextPage.value ?: 1)
            }
        }

    init {
        addSource(results)
    }

    fun setQuery(originalInput: String) {
        val input = originalInput.toLowerCase(Locale.getDefault()).trim()
        if (input == query.value) return
        query.value = input
    }

    fun reqNextPage(next: Int) {
        if (nextPage.value == next) return
        nextPage.value = next
        val temp = query.value
        query.value = ""
        query.value = temp
    }

    private fun searchRepo(
        query: String,
        page: Int = 1
    ): LiveData<Resource<List<RecyclerViewItem>?>> {
        val liveData = MutableLiveData<Resource<List<RecyclerViewItem>?>>()
        scope.launch {
            searchReposUseCase(SearchReposUseCase.Input(query = query, page = page)) {
                onSubscribe { liveData.value = Resource.loading() }
                onSuccess { repos ->
                    repos?.let { list ->
                        val repoItems = list.map {
                            SearchRepoItem(repoModelMapper.map(it))
                        }
                        liveData.value = Resource.success(repoItems)
                    }
                }
                onError { liveData.value = Resource.error(it) }
            }
        }
        return liveData
    }
}
