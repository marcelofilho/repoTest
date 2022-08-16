package com.example.testerepo.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.testerepo.domain.entity.RepoItem
import com.example.testerepo.domain.repository.RepoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class RepoViewModel(
    private val repoRepository: RepoRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _sucesso: MutableLiveData<PagingData<RepoItem>> = MutableLiveData()

    val sucesso: LiveData<PagingData<RepoItem>>
        get() = _sucesso

    private val _error: MutableLiveData<String> = MutableLiveData()

    val error: LiveData<String>
        get() = _error

    fun getRepo(): Flow<PagingData<RepoItem>> {
           return repoRepository.getRepo("language:kotlin","stars","1").catch {
               println()
           }

    }

}