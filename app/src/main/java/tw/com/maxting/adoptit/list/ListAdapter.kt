package tw.com.maxting.adoptit.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import tw.com.maxting.adoptit.R
import tw.com.maxting.adoptit.data.Adopt

class ListAdapter : PagedListAdapter<Adopt, ListViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_adopt, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        getItem(position)
                ?.also { holder.bind(it) }
    }

    companion object {
        private val DIFF_CALLBACK = object :
                DiffUtil.ItemCallback<Adopt>() {
            override fun areItemsTheSame(oldItem: Adopt, newItem: Adopt) =
                    oldItem.animalId == newItem.animalId

            override fun areContentsTheSame(oldItem: Adopt, newItem: Adopt) =
                    oldItem == newItem
        }
    }
}