package org.example.repository

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import org.example.entities.User
import org.example.utils.HibernateUtils


class UserRepository {

    fun findName(username: String): User?{

        val em = HibernateUtils.getEntityManagerFactory()

        val transaction = em.transaction
        var user: User? = null

        try {
            transaction.begin()
            user = em.find(User::class.java, username)
            transaction.commit()
        }
        catch (e: Exception){
            transaction.rollback()
            println(e)
        }
        finally {
            em.close()
        }
        return user
    }
}