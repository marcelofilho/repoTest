package com.example.testerepo.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepoResponse(

    @SerialName("items")
    val items: List<ItemResponse>
)