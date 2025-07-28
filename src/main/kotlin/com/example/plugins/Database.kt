package com.example.plugins

import com.example.entity.UserTable
import io.ktor.server.config.ApplicationConfig
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object Database {
    fun init(appConfig: ApplicationConfig){
        val dbConfig = appConfig.config("postgres")

        Database.connect(
            url = dbConfig.property("url").getString(),
            driver = dbConfig.property("driver").getString(),
            user = dbConfig.property("user").getString(),
            password = dbConfig.property("password").getString()
        )

        transaction {
            SchemaUtils.create(UserTable)
        }
    }
}