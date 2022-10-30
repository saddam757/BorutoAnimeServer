package com.shcoding

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.shcoding.plugins.*
import io.ktor.server.application.*

fun main() {
    embeddedServer(Netty,
        environment = applicationEngineEnvironment {
            developmentMode = true
            connector {
                port = 8080
                host = "0.0.0.0"
            }
            watchPaths = listOf("classes","resources")
            module {
                module()
            }
        }) {

    }.start(wait = true)
}

fun Application.module() {
    configureKoin()
    configureSerialization()
    configureMonitoring()
    configureHTTP()
    configureRouting()
}
