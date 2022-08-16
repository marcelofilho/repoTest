package com.example.testerepo.data.local

import android.content.SharedPreferences
import androidx.paging.PagingData
import com.example.testerepo.data.model.response.ItemResponse
import com.example.testerepo.data.model.response.RepoResponse

interface RepoLocalDataSource{
    fun save(repoResponse: PagingData<ItemResponse>)
    fun get(): PagingData<ItemResponse>
}