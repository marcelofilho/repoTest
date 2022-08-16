package com.example.testerepo.data.source

import androidx.paging.PagingData
import com.example.testerepo.data.model.response.ItemResponse
import com.example.testerepo.data.model.response.RepoResponse
import kotlinx.coroutines.flow.Flow

interface RepoDataSource {

    fun getRepo(language: String, sort: String, page: String): Flow<PagingData<ItemResponse>>
}