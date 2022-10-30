package com.shcoding.routes

import com.shcoding.domain.repository.HeroRepository
import com.shcoding.routes.util.EndPoints
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.searchHeroes() {
    val repository: HeroRepository by inject()
    get(EndPoints.SEARCH_HEROES) {

        val name = call.request.queryParameters["name"]
        val response = repository.searchHeroes(name)

        call.respond(
            message = response,
            status = HttpStatusCode.OK
        )

    }
}