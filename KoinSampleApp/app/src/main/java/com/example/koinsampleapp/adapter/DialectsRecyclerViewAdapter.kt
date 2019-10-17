package br.com.tw.shufflesongsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.koinsampleapp.R
import com.example.koinsampleapp.model.Dialect
import kotlinx.android.synthetic.main.dialects_list_item.view.*

class DialectsRecyclerViewAdapter(private val dialects: List<Dialect>?) :
    RecyclerView.Adapter<DialectsRecyclerViewAdapter.DialectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dialects_list_item, parent, false)
        return DialectViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dialects?.size ?: 0
    }

    override fun onBindViewHolder(holder: DialectViewHolder, position: Int) {
        dialects?.let {

            holder.dialectName.text =  it[position].dialect
            holder.meaning.text =  it[position].meanings[0]


//            holder.regionDescription.setOnClickListener {
//                val context = holder.regionDescription.context
//                val intent = Intent(context, DialectActivity::class.java)
//                intent.putExtra("REGION", holder.regionDescription.toString())
//                context.startActivity(intent)
//            }
        }
    }

    class DialectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dialectName = itemView.dialectName
        val meaning = itemView.meaning

    }
}