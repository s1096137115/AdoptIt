package tw.com.maxting.adoptit.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tw.com.maxting.adoptit.data.Adopt
import tw.com.maxting.adoptit.singleton.Repository

class DetailViewModel(private val repository: Repository) : ViewModel() {

    val adopt = MutableLiveData<Adopt>()

}