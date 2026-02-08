package com.compose.dicodingpemula

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.compose.dicodingpemula.databinding.ItemRowTeamBinding

class ListTeamsAdapter (private val listTeam: ArrayList<Teams>) : RecyclerView.Adapter<ListTeamsAdapter.ListViewHolder>() {

  private lateinit var onItemClickCallback: OnItemClickCallback

  fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
    this.onItemClickCallback = onItemClickCallback
  }


  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ListViewHolder {
    val binding = ItemRowTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ListViewHolder(binding)
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

  class ListViewHolder(binding: ItemRowTeamBinding) : RecyclerView.ViewHolder(binding.root) {
    val imgLogo: ImageView = binding.imgItemLogo
    val tvName: TextView = binding.tvItemName
    val tvInfo: TextView = binding.tvItemInfo
  }

  interface OnItemClickCallback {
    fun onItemClicked(data: Teams)
  }

}