package com.example.service

import com.example.model.User

interface UserService {
    suspend fun getAll(): List<User>
    suspend fun getById(id: Int): User?
    suspend fun create(user: User): User
    suspend fun update(id: Int, user: User): Boolean
    suspend fun delete(id: Int): Boolean
}