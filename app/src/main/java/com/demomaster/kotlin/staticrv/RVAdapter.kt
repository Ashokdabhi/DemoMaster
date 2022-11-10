package com.demomaster.kotlin.staticrv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demomaster.databinding.StatickItemViewBinding

class RVAdapter(private val nameList: ArrayList<String>) : RecyclerView.Adapter<RVAdapter.RvViewHolder>() {

    inner class RvViewHolder(val binding: StatickItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        val binding =
            StatickItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RvViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.binding.txtName.text = nameList[position]
    }

    override fun getItemCount(): Int {
        return nameList.size
    }
}