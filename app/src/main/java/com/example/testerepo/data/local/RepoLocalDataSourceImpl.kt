package com.example.testerepo.data.local

import android.content.SharedPreferences
import androidx.paging.PagingData
import com.example.testerepo.data.model.response.ItemResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

const val SHARED_PREFERENCE_REPO_KEY = "SHARED_PREFERENCE_REPO_KEY"


class RepoLocalDataSourceImpl(private val sharedPreferences: SharedPreferences): RepoLocalDataSource {
    override fun save(repoResponse: PagingData<ItemResponse>) {
        sharedPreferences.edit().putString(SHARED_PREFERENCE_REPO_KEY, Gson().toJson(repoResponse)).apply()
    }

        override fun get(): PagingData<ItemResponse> {
        val json = sharedPreferences.getString(SHARED_PREFERENCE_REPO_KEY, null)
        val typeToken  = object : TypeToken<PagingData<ItemResponse>>() {}.type
        return Gson().fromJson(json,typeToken)
    }
}


