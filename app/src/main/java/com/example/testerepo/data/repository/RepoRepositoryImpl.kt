package com.example.testerepo.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.example.testerepo.data.local.RepoLocalDataSourceImpl
import com.example.testerepo.data.mapper.RepoMapper
import com.example.testerepo.data.source.RepoDataSource
import com.example.testerepo.domain.entity.RepoItem
import com.example.testerepo.domain.repository.RepoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class RepoRepositoryImpl(
    private val dataSource: RepoDataSource,
    private val repoMapper: RepoMapper
) : RepoRepository {
    override fun getRepo(language: String, sort: String, page: String): Flow<PagingData<RepoItem>> {
        return dataSource.getRepo(language, sort, page).map {repoResponse ->
            repoResponse.map {
                repoMapper.map(repoResponse = it)
            }
        }
    }
}