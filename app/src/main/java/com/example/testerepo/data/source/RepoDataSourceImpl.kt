package com.example.testerepo.data.source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.testerepo.data.api.RepoService
import com.example.testerepo.data.local.RepoLocalDataSourceImpl
import com.example.testerepo.data.model.response.ItemResponse
import com.example.testerepo.data.model.response.RepoResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class RepoDataSourceImpl(
    private val repoPagingDataSource: RepoPagingDataSource,
) : RepoDataSource {
//    override fun getRepo(language: String, sort: String, page: String): Flow<RepoResponse>  = flow {
//        emit(repoService.getRepo(language, sort, page))
//    }

    override fun getRepo(
        language: String,
        sort: String,
        page: String
    ): Flow<PagingData<ItemResponse>> {
        return Pager(
            config = PagingConfig(
                pageSize = 1
            ),
            pagingSourceFactory = {
                repoPagingDataSource
            }
        ).flow
    }

}