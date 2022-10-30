package com.shcoding.domain.util

import com.shcoding.domain.model.Hero
import kotlinx.serialization.Serializable

@Serializable
data class ServerResponse(
    val success: Boolean,
    val message: String? = null,
    val nextPage: Int? = null,
    val prevPage: Int? = null,
    val heroes: List<Hero> = emptyList()

)
