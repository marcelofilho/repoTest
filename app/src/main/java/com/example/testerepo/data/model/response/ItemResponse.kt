package com.example.testerepo.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemResponse(

    @SerialName("name")
    val name: String,
    @SerialName("forks_count")
    val forks_count: String,
    @SerialName("stargazers_count")
    val stargazers_count: String,
    @SerialName("owner")
    val owner: OwnerResponse
) {
}