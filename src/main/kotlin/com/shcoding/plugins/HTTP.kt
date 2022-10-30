package com.shcoding.plugins

import io.ktor.http.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.application.*
import java.time.Duration

fun Application.configureHTTP() {
    install(DefaultHeaders) {
        val oneYearInSecond = Duration.ofDays(365).seconds

        header(
            name = HttpHeaders.CacheControl,
            value = "public, max-age=$oneYearInSecond, Immutable"
        )

    }

}
