package tw.com.maxting.adoptit.list

import androidx.paging.DataSource
import androidx.paging.PositionalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import tw.com.maxting.adoptit.data.Adopt
import tw.com.maxting.adoptit.singleton.Repository

class ListDataSource(
        private val repository: Repository,
        private val scope: CoroutineScope
) : PositionalDataSource<Adopt>() {

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Adopt>) {
        val position = computeInitialLoadPosition(params, LOAD_COUNT)
        val loadSize = computeInitialLoadSize(params, position, LOAD_COUNT)
        scope.launch {
            runCatching {
                repository.fetchAdopts(loadSize, 0)
            }.onSuccess { list ->
                list
                        .toMutableList()
                        .also { filterList ->
                            callback.onResult(
                                    filterList,
                                    position,
                                    TOTAL_COUNT
                            )
                        }
            }
        }
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Adopt>) {
        scope.launch {
            runCatching {
                repository.fetchAdopts(params.loadSize, params.startPosition)
            }.onSuccess { list ->
                list
                        .toMutableList()
                        .also { filterList ->
                            callback.onResult(filterList)
                        }
            }
        }
    }

    override fun invalidate() {
        super.invalidate()
        scope.cancel()
    }

    class Factory(
            private val repository: Repository,
            private val scope: CoroutineScope
    ) : DataSource.Factory<Int, Adopt>() {

        private var dataSource: ListDataSource? = null

        override fun create(): DataSource<Int, Adopt> {
            return ListDataSource(repository, scope).also { dataSource = it }
        }

        fun getDataSource() = dataSource
    }

    companion object {
        const val PAGE_SIZE = 20
        const val LOAD_COUNT = 20
        const val TOTAL_COUNT = 10000
    }
}