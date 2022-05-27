package com.example.dotaheroyokhttp.model.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dotaheroyokhttp.R
import com.example.dotaheroyokhttp.databinding.CardViewDesignBinding
import com.example.dotaheroyokhttp.model.data.HeroyItemItemX

class HeroyAdapter(
    val hItemClickListener: ItemClickListener,
    private val hList: List<HeroyItemItemX>

) : RecyclerView.Adapter<HeroyAdapter.ViewHolder>() {


    interface ItemClickListener {
        fun onClickItem(position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.PhotoHero.load("https://api.opendota.com${hList[position].img}")
        holder.binding.nameHero.text = hList[position].localized_name
        holder.binding.PhotoHero.setOnClickListener{
            hItemClickListener.onClickItem(position)
        }
    }

    override fun getItemCount(): Int {
        return hList.size
    }

     class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val binding = CardViewDesignBinding.bind(itemView)
    }
}



