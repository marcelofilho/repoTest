package com.example.testerepo.domain.repository

import androidx.paging.PagingData
import com.example.testerepo.domain.entity.RepoItem
import kotlinx.coroutines.flow.Flow

interface RepoRepository {

    fun getRepo(language: String, sort: String, page: String): Flow<PagingData<RepoItem>>
}