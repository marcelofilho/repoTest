package com.example.testerepo.di

import android.content.Context
import android.content.SharedPreferences
import com.example.testerepo.data.api.RepoService
import com.example.testerepo.data.mapper.RepoMapper
import com.example.testerepo.data.repository.RepoRepositoryImpl
import com.example.testerepo.data.source.RepoDataSourceImpl
import com.example.testerepo.data.source.RepoPagingDataSource
import com.example.testerepo.domain.repository.RepoRepository
import com.example.testerepo.presentation.viewmodel.RepoViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val CONSUMER_DATA_SHARED_PREF_NAME = "prefs"

val repoModule = module {

    single{
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()
    }

    single{
        Retrofit.Builder().
        baseUrl("https://api.github.com/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<SharedPreferences>(named("shared")){
        get<Context>().getSharedPreferences(CONSUMER_DATA_SHARED_PREF_NAME,0)
    }

    viewModel {
        RepoViewModel(
            repoRepository = RepoRepositoryImpl(
                dataSource = RepoDataSourceImpl(
                    repoPagingDataSource = RepoPagingDataSource(
                        get<Retrofit>().create(RepoService::class.java)
                    )
                ),
                repoMapper = RepoMapper()
            )
        )
    }

    factory<RepoRepository> {
        RepoRepositoryImpl(
            dataSource = RepoDataSourceImpl(
                repoPagingDataSource = RepoPagingDataSource(
                    get<Retrofit>().create(RepoService::class.java)
                )
            ),
            repoMapper = RepoMapper()
        )
    }

}