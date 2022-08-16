package com.example.testerepo.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.testerepo.data.api.RepoService
import com.example.testerepo.data.local.RepoLocalDataSourceImpl
import com.example.testerepo.data.model.response.ItemResponse
import com.example.testerepo.data.model.response.RepoResponse
import okio.IOException
import retrofit2.HttpException


private const val TMDB_STARTING_PAGE_INDEX = 1

class RepoPagingDataSource(private val repoService: RepoService):
    PagingSource<Int, ItemResponse>() {

    override fun getRefreshKey(state: PagingState<Int, ItemResponse>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemResponse> {
        val pageIndex = params.key ?: TMDB_STARTING_PAGE_INDEX
        return try {
            val response = repoService.getRepo(
                language = "language=kotlin",
                sort = "stars",
                page = pageIndex.toString()
            )
            val repo = response
            val nextKey =
                if (repo.items.isEmpty()) {
                    null
                } else {
                    pageIndex + (params.loadSize)
                }
            LoadResult.Page(
                data = repo.items,
                prevKey = if (pageIndex == TMDB_STARTING_PAGE_INDEX) null else pageIndex,
                nextKey = nextKey
            )

        } catch (exception: IOException) {
            return throw Throwable()
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}