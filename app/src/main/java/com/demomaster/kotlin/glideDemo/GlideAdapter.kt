package com.demomaster.kotlin.glideDemo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demomaster.databinding.LiveItemViewBinding

class GlideAdapter(private val mContext: Context, private val dataModelList: ArrayList<DataModel>) :
    RecyclerView.Adapter<GlideAdapter.GlideViewHolder>() {
    inner class GlideViewHolder(val binding: LiveItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GlideViewHolder {
        val binding = LiveItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GlideViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GlideViewHolder, position: Int) {
        Glide.with(mContext)
            .load(dataModelList[position].imgURL)
            .into(holder.binding.iv)
        holder.binding.name.text = dataModelList[position].name
        holder.binding.country.text = dataModelList[position].country
        holder.binding.city.text = dataModelList[position].city
    }

    override fun getItemCount(): Int {
        return dataModelList.size
    }
}