package br.com.tw.shufflesongsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.koinsampleapp.R
import com.example.koinsampleapp.model.Region
import kotlinx.android.synthetic.main.regions_list_item.view.*

class RegionsRecyclerViewAdapter(private val regions: List<Region>?) :
    RecyclerView.Adapter<RegionsRecyclerViewAdapter.RegionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.regions_list_item, parent, false)
        return RegionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return regions?.size ?: 0
    }

    override fun onBindViewHolder(holder: RegionViewHolder, position: Int) {
        regions?.let {
            holder.regionDescription.text = it[position].name + " (" + it[position].total + ")"
        }
    }
    class RegionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val regionDescription = itemView.regionDescription
    }
}