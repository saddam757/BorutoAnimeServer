package com.shcoding.routes

import com.shcoding.domain.repository.HeroRepository
import com.shcoding.domain.util.ServerResponse
import com.shcoding.routes.util.EndPoints
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.allHeroes() {

    val repository: HeroRepository by inject()

    get(EndPoints.ALL_HEROES) {

        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)

            val response = repository.getAllHeroes(page)

            call.respond(message = response, status = HttpStatusCode.OK)

        } catch (e: NumberFormatException) {

            call.respond(
                status = HttpStatusCode.BadRequest,
                message = ServerResponse(
                    success = false,
                    message = "Only numbers allowed!!"
                )
            )

        } catch (e: IllegalArgumentException) {

            call.respond(
                status = HttpStatusCode.NotFound,
                message = ServerResponse(
                    success = false,
                    message = "Heroes not found!!"
                )
            )

        }
    }

}