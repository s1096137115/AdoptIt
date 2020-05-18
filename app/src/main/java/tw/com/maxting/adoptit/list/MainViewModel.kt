package tw.com.maxting.adoptit.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.jetbrains.anko.AnkoLogger
import tw.com.maxting.adoptit.paging.ListStatus
import tw.com.maxting.adoptit.paging.makePagedList
import tw.com.maxting.adoptit.singleton.Repository

class MainViewModel(private val repository: Repository) : ViewModel(), AnkoLogger {

    val listStatus = MutableLiveData<ListStatus>()

    private val factory by lazy {
        ListDataSource.Factory(repository, viewModelScope)
    }

    fun loadAdoptPaged() = factory.makePagedList(listStatus, ListDataSource.PAGE_SIZE, 10)

}