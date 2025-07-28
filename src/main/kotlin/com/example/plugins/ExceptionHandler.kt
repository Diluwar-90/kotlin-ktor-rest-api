package com.example.plugins

import com.example.exception.BadRequestException
import com.example.exception.NotFoundException
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond

fun Application.configureExceptionHandling(){
    install(StatusPages) {
        exception<BadRequestException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, mapOf("error" to cause.message))
        }

        exception<NotFoundException> { call, cause ->
            call.respond(HttpStatusCode.NotFound, mapOf("error" to cause.message))
        }

        exception<Throwable> { call, cause ->
            cause.printStackTrace() // Optional: Log the full stack trace
            call.respond(HttpStatusCode.InternalServerError, mapOf("error" to "Internal Server Error"))
        }
    }
}