package com.shcoding.plugins

import com.shcoding.di.HeroModule
import io.ktor.server.application.*
import org.koin.ksp.generated.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin(){

    install(Koin){
        slf4jLogger()
        modules(HeroModule().module)
    }
}