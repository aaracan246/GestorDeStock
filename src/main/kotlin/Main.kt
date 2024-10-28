package org.example

import org.example.controllers.GestorLogin
import org.example.repository.UserRepository
import org.example.utils.HibernateUtils

fun main() {

    val em = HibernateUtils.getEntityManagerFactory().createEntityManager()
    val userRepository = UserRepository()
    val gestorLogin = GestorLogin(userRepository)

    println("Please, insert your username: ")
    val userRequest: String = readln()

    val userBDD = userRepository.findName(userRequest)

    if (userBDD != null && userBDD.name == userRequest){
        println("Please, insert your password: ")
        var passwordRequest: Int? = null
        while (passwordRequest == null){
                passwordRequest = readln().toIntOrNull()
        }
        if (userBDD.password == passwordRequest){
            println("Entering database. . .")
        }
        else{
            println("Wrong password")
        }

    }
    else{
        println("That username is not on our database.")
    }



}