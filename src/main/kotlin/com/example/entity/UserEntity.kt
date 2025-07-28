package com.example.entity

import com.example.model.User
import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object UserTable : IntIdTable("users"){
    val name = varchar("name",100)
    val email = varchar("email",100)
}

class UserEntity(id: EntityID<Int>): IntEntity(id){
    companion object: IntEntityClass<UserEntity>(UserTable)

    var name by UserTable.name
    var email by UserTable.email

    fun toDomain(): User = User(
        id = id.value,
        name = name,
        email = email
    )
}