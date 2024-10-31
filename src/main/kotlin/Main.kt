package org.example

import org.example.controllers.ControllerLogin
import org.example.controllers.ControllerMenu
import org.example.entities.User
import org.example.repository.ProductRepository
import org.example.repository.ProviderRepository
import org.example.repository.UserRepository
import org.example.utils.HibernateUtils

fun main() {

    val em = HibernateUtils.getEntityManagerFactory()
    val userRepository = UserRepository()
    val productRepository = ProductRepository()
    val providerRepository = ProviderRepository()
    val controllerLogin = ControllerLogin(userRepository)
    val controllerMenu = ControllerMenu(em, productRepository, providerRepository)


//    em.transaction.begin()
//    val user1 = User("1234", "Morri")
//    em.persist(user1)
//    em.transaction.commit()
//    em.close()

    println("Please, insert your username: ")
    val userRequest: String = readln()
    println("Please, insert your password: ")
    val passwordRequest: String = readln()

    val userBDD = controllerLogin.authentication(userRequest, passwordRequest)

    if (userBDD){
        println("Access granted")
        println(".")
        println(".")
        println(".")
        controllerMenu.menu()
    }
    else{
        println("Access denied")
    }
}