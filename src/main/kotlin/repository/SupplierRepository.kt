package org.example.repository

import org.example.entities.Supplier
import org.example.utils.HibernateUtils


class SupplierRepository {

    private val em = HibernateUtils.getEntityManagerFactory()

    fun getSupplierProd(): List<Supplier>{
        val query = em.createQuery("SELECT pr FROM Supplier pr", Supplier::class.java) // !!!!!??? este está mal
        return query.resultList
    }

    fun getAllSuppliers(): List<Supplier>{
        val query = em.createQuery("SELECT pr FROM Supplier pr", Supplier::class.java)
        return query.resultList
    }
}
