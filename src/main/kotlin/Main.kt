package org.example

import org.example.controllers.GestorLogin
import org.example.entities.User
import org.example.repository.UserRepository
import org.example.utils.HibernateUtils

fun main() {

    val em = HibernateUtils.getEntityManagerFactory()
    val userRepository = UserRepository()
    val gestorLogin = GestorLogin(userRepository)

    em.transaction.begin()
    val user1 = User("1234", "Morri")
    em.persist(user1)
    em.transaction.commit()
    em.close()

    println("Please, insert your username: ")
    val userRequest: String = readln()
    println("Please, insert your password: ")
    val passwordRequest: String = readln()

    val userBDD = gestorLogin.authentication(userRequest, passwordRequest)

    if (userBDD){
        println("Access granted")
    }
    else{
        println("Access denied")
    }
}