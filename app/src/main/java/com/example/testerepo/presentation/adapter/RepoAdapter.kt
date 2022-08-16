package com.example.testerepo.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testerepo.databinding.ItemRepoBinding
import com.example.testerepo.domain.entity.RepoItem
import com.example.testerepo.presentation.holders.RepoViewHolder

class RepoAdapter : PagingDataAdapter<RepoItem, RecyclerView.ViewHolder>(DiffCallBackItem()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RepoViewHolder(
            ItemRepoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val repoItem: RepoItem? = getItem(position)
           (holder as RepoViewHolder).bind(repoItem)
    }
}

internal class DiffCallBackItem : DiffUtil.ItemCallback<RepoItem>() {
    override fun areContentsTheSame(oldItem: RepoItem, newItem: RepoItem): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: RepoItem, newItem: RepoItem): Boolean {
        return oldItem == newItem
    }
}
