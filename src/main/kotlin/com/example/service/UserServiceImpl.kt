package com.example.service

import com.example.exception.BadRequestException
import com.example.exception.NotFoundException
import com.example.model.User
import com.example.repository.UserRepository

class UserServiceImpl(
    private val repository: UserRepository
) : UserService {
    override suspend fun getAll(): List<User> = repository.getAll()

    override suspend fun getById(id: Int): User? = repository.getById(id)?: throw NotFoundException("User with ID $id not found")

    override suspend fun create(user: User): User {
        validateUser(user)
       val existingUser = repository.getAll()
        if (existingUser.any{it.email == user.email}){
            throw BadRequestException("Email '${user.email}' already exists")
        }
        return repository.create(user)
    }

    override suspend fun update(id: Int, user: User): Boolean {
        validateUser(user)
        val exists = repository.getById(id)
        if (exists == null) throw NotFoundException("User with ID $id not found")
        return repository.update(id,user)
    }

    override suspend fun delete(id: Int): Boolean {
        val deleted = repository.delete(id)
        if (!deleted) throw NotFoundException("User with ID $id not found")
        return repository.delete(id)
    }

    private fun validateUser(user: User) {
        if (user.name.isBlank()) throw BadRequestException("Name cannot be blank")
        if (!user.email.contains("@")) throw BadRequestException("Invalid email format")
    }
}