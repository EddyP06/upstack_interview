package com.eddy.upstackinterviewapp.ui.features.repo.adapter

import androidx.recyclerview.widget.RecyclerView
import com.eddy.upstackinterviewapp.data.entity.RepositoryEntity
import com.eddy.upstackinterviewapp.databinding.ItemRepoBinding

class RepoViewHolder(private val item: ItemRepoBinding ): RecyclerView.ViewHolder(item.root) {
    fun bind(repoItem: RepositoryEntity) {
        item.textView.text = repoItem.name
    }
}