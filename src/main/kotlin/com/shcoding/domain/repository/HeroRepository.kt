package com.shcoding.domain.repository

import com.shcoding.domain.model.Hero
import com.shcoding.domain.util.ServerResponse

interface HeroRepository {

    val heroes: Map<Int, List<Hero>>

    val page1: List<Hero>
    val page2: List<Hero>
    val page3: List<Hero>
    val page4: List<Hero>
    val page5: List<Hero>

    suspend fun getAllHeroes(page: Int = 1): ServerResponse
    suspend fun searchHeroes(name: String?): ServerResponse
}