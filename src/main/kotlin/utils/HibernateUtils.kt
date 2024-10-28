package org.example.utils

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence


object HibernateUtils {
    private val _emf: EntityManagerFactory = Persistence.createEntityManagerFactory("controldestock")

    fun getEntityManagerFactory(): EntityManagerFactory{
        return _emf
    }

}