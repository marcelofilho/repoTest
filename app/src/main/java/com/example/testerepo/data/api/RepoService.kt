package com.example.testerepo.data.api

import com.example.testerepo.data.model.response.RepoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RepoService{

    @GET("search/repositories")
    suspend fun getRepo(
        @Query("q") language: String,
        @Query("sort") sort: String,
        @Query("page") page: String,
    ): RepoResponse
}