package com.shcoding.plugins

import com.shcoding.routes.allHeroes
import com.shcoding.routes.root
import com.shcoding.routes.searchHeroes
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import kotlinx.html.*

fun Application.configureRouting() {
    install(StatusPages) {
        exception<AuthenticationException> { call, cause ->
            call.respond(HttpStatusCode.Unauthorized)
        }
        exception<AuthorizationException> { call, cause ->
            call.respond(HttpStatusCode.Forbidden)
        }

    }


    routing {
        root()
        allHeroes()
        searchHeroes()
        // Static plugin. Try to access `/images`
        static(remotePath = "/images") {
            resources("images")
        }
    }
}

class AuthenticationException : RuntimeException()
class AuthorizationException : RuntimeException()
