package org.example.repository

import org.example.utils.HibernateUtils
import java.security.Provider

class ProviderRepository {

    private val em = HibernateUtils.getEntityManagerFactory()

    fun getProvidersProd(): List<Provider>{
        val query = em.createQuery("SELECT p FROM providers p", Provider::class.java) // !!!!!???
        return query.resultList
    }

    fun getAllProviders(){}
}