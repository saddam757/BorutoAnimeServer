package com.shcoding.routes

import com.shcoding.routes.util.EndPoints
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
fun Route.root() {

    get(EndPoints.ROOT) {
        call.respond(
            message = "Welcome to boruto anime server powered by ktor!",
            status = HttpStatusCode.OK
        )

    }

}