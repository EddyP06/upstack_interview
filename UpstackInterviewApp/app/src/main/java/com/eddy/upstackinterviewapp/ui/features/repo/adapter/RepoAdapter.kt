package com.eddy.upstackinterviewapp.ui.features.repo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eddy.upstackinterviewapp.data.entity.RepositoryEntity
import com.eddy.upstackinterviewapp.databinding.ItemRepoBinding

class RepoAdapter : RecyclerView.Adapter<RepoViewHolder>() {
    var itemData: MutableList<RepositoryEntity> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(itemData[position])
    }

    override fun getItemCount(): Int= itemData.size
}