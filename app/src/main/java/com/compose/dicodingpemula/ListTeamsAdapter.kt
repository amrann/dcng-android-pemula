package com.compose.dicodingpemula

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListTeamsAdapter (private val listTeam: ArrayList<Teams>) : RecyclerView.Adapter<ListTeamsAdapter.ListViewHolder>() {

  private lateinit var onItemClickCallback: OnItemClickCallback

  fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
    this.onItemClickCallback = onItemClickCallback
  }


  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ListViewHolder {
    val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_team, parent, false)
    return ListViewHolder(view)
  }

  override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
    val (name, info, logo) = listTeam[position]
    holder.imgLogo.setImageResource(logo)
    holder.tvName.text = name
    holder.tvInfo.text = info
    holder.itemView.setOnClickListener {
      onItemClickCallback.onItemClicked(listTeam[holder.adapterPosition])
    }
  }

  override fun getItemCount(): Int = listTeam.size

  class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imgLogo: ImageView = itemView.findViewById(R.id.img_item_logo)
    val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
    val tvInfo: TextView = itemView.findViewById(R.id.tv_item_info)
  }

  interface OnItemClickCallback {
    fun onItemClicked(data: Teams)
  }

}