package com.example.testerepo.domain.entity

import com.example.testerepo.data.model.response.OwnerResponse
import kotlinx.serialization.SerialName

data class RepoItem(
    val name: String,
    val forks: String,
    val starsCount: String,
    val ownerName: String,
    val ownerImage: String
)