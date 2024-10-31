package org.example.controllers

import org.example.repository.UserRepository

class ControllerLogin(private val userRepository: UserRepository) {

    fun authentication(username: String, password: String): Boolean{
        val user = userRepository.findName(username)
        return user?.password == password
    }
}