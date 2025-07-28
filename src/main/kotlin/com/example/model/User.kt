package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int? = null,
    val name: String,
    val email: String
)