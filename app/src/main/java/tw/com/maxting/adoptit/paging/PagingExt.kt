package tw.com.moneybook.moneybook.data.adaptation.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

fun <Key, Value> DataSource.Factory<Key, Value>.makePagedList(
        listStatus: MutableLiveData<ListStatus>,
        pageSize: Int,
        distance: Int,
        enablePlaceholders: Boolean = true
): LiveData<PagedList<Value>> {

    fun makePagedListConfig(
            pageSize: Int,
            distance: Int,
            enablePlaceholders: Boolean
    ): PagedList.Config =
            PagedList.Config.Builder().apply {
                setPageSize(pageSize) //设置每一页加载的数量
                setInitialLoadSizeHint(pageSize) //设置首次加载的数量
                setPrefetchDistance(distance) //设置距离最后还有多少个item时，即寻呼库开始加载下一页的数据
                setEnablePlaceholders(enablePlaceholders)
            }.build()


    return LivePagedListBuilder(
            this,
            makePagedListConfig(pageSize, distance, enablePlaceholders)
    )
            .setBoundaryCallback(ListBoundaryCallback(listStatus))
            .build()
}
