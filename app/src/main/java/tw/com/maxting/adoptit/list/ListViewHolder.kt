package tw.com.maxting.adoptit.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_adopt.view.*
import tw.com.maxting.adoptit.data.Adopt

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(adopt: Adopt) {
        itemView.apply {
            Glide.with(this)
                    .load(adopt.albumFile)
                    .centerCrop()
                    .into(iv_picture)
        }
    }
}