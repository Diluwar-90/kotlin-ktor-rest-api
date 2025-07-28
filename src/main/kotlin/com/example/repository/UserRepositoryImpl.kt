package com.example.repository

import com.example.entity.UserEntity
import com.example.model.User
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class UserRepositoryImpl: UserRepository {
    override suspend fun getAll(): List<User> = newSuspendedTransaction {
        UserEntity.all().map { it.toDomain() }
    }

    override suspend fun getById(id: Int): User? = newSuspendedTransaction {
        UserEntity.findById(id)?.toDomain()
    }

    override suspend fun create(user: User): User = newSuspendedTransaction {
        UserEntity.new {
            name = user.name
            email = user.email
        }.toDomain()
    }

    override suspend fun update(id: Int, user: User): Boolean = newSuspendedTransaction {
        val existing = UserEntity.findById(id)
        if (existing != null){
            existing.name = user.name
            existing.email = user.email
            true
        } else {
            false
        }
    }

    override suspend fun delete(id: Int): Boolean = newSuspendedTransaction {
        UserEntity.findById(id)?.delete() != null
    }
}