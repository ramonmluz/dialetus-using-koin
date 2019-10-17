package br.com.tw.shufflesongsapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.koinsampleapp.R
import com.example.koinsampleapp.model.Region
import com.example.koinsampleapp.ui.DialectActivity
import kotlinx.android.synthetic.main.regions_list_item.view.*

class RegionsRecyclerViewAdapter(private val regions: List<Region>?) :
    RecyclerView.Adapter<RegionsRecyclerViewAdapter.RegionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.regions_list_item, parent, false)
        return RegionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return regions?.size ?: 0
    }

    override fun onBindViewHolder(holder: RegionViewHolder, position: Int) {
        regions?.let {
            holder.regionDescription.tag = it[position].name
            holder.regionDescription.text = holder.regionDescription.tag.toString() + " (" + it[position].total + ")"
            holder.regionDescription.setOnClickListener {
                val context = holder.regionDescription.context
                val intent = Intent(context, DialectActivity::class.java)
                intent.putExtra("REGION", holder.regionDescription.tag.toString())
                context.startActivity(intent)
            }
        }
    }

    class RegionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val regionDescription = itemView.regionDescription!!
    }

}