package tw.com.maxting.adoptit.list

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_adopt.view.*
import tw.com.maxting.adoptit.R
import tw.com.maxting.adoptit.data.Adopt
import tw.com.maxting.adoptit.detail.DetailActivity

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    lateinit var adopt: Adopt

    init {
        itemView.apply {
            setOnClickListener { it ->
                val intent = Intent(it.context, DetailActivity::class.java).also {
                    it.putExtra(Adopt.toString(), adopt)
                }
                val options = ActivityOptions.makeSceneTransitionAnimation(
                        it.context as Activity,
                        iv_picture,
                        "shared_element_container"
                )
                it.context.startActivity(intent, options.toBundle())
            }
        }
    }

    fun bind(adopt: Adopt) {
        this.adopt = adopt
        itemView.apply {
            Glide.with(this)
                    .load(adopt.albumFile)
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(iv_picture)
        }
    }
}