package com.example.testerepo.data.mapper

import com.example.testerepo.data.model.response.ItemResponse
import com.example.testerepo.data.model.response.RepoResponse
import com.example.testerepo.data.source.RepoDataSource
import com.example.testerepo.domain.entity.RepoItem

class RepoMapper(){
    fun map(repoResponse: ItemResponse): RepoItem{
        return RepoItem(
                    name = repoResponse.name,
                    forks = repoResponse.forks_count,
                    starsCount = repoResponse.stargazers_count,
                    ownerName = repoResponse.owner.login,
                    ownerImage = repoResponse.owner.avatar_url
                )
        }
}