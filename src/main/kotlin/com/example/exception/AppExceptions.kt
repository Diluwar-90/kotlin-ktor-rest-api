package com.example.exception

class BadRequestException(message: String) : RuntimeException(message)
class NotFoundException(message: String) : RuntimeException(message)
