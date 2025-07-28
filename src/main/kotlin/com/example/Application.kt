package com.example

import com.example.plugins.Database
import com.example.plugins.configureCORS
import com.example.plugins.configureExceptionHandling
import com.example.plugins.configureSerialization
import configureRouting
import io.ktor.server.application.*
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    configureExceptionHandling()
    configureCORS()
    configureSerialization()
    configureRouting()
    Database.init(environment.config)
}
