package com.example.testerepo.presentation.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.testerepo.databinding.ItemRepoBinding
import com.example.testerepo.domain.entity.RepoItem
import com.squareup.picasso.Picasso

class RepoViewHolder( private val binding: ItemRepoBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: RepoItem?) {
        setupView(item)
    }

    private fun setupView(item: RepoItem?) {
        with(binding) {
            repoName.text = item?.name
            Picasso.get().load(item?.ownerImage).into(authorRepoImage);
            authorRepoName.text = item?.ownerName
           starsCount.text = item?.starsCount
               forkCount.text =  item?.forks
        }
    }
}