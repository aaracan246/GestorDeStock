package org.example.repository

import org.example.entities.Product
import org.example.utils.HibernateUtils

class ProductRepository {

    private val em = HibernateUtils.getEntityManagerFactory()

//    fun askProdData(): Product{
//
//        println("Please, insert the name of the product: ")
//        val prodName = readln()
//
//        println("Please, insert the price of the product(no IVA): ")
//        val priceNoIVA = readln().toFloat()
//        val priceIVA = priceNoIVA * 1.21f
//
//        println("Please, insert a description for the product: ")
//        val prodDesc = readln()
//
//
//        println("Please, insert the stock: ")
//        val prodStock = readln().toInt()
//
//        println("Please, insert the name of the provider: ")
//        val providerName = readln()
//
//        println("Please, insert the address of the provider: ")
//        val dirProvider = readln()
//
//
//
//        return Product(prodName, prodDesc, priceNoIVA, priceIVA, Date(), prodStock, providerName, null)
//    }

    fun registerProduct(product: Product){

        try {
            em.transaction.begin()
            em.persist(product)
            println("The product was registered successfully!")
            em.transaction.commit()
        }
        catch (e: Exception){
            em.transaction.rollback()
            throw e
        }
        finally {
            em.close()
        }
    }

    fun deregisterProduct(id: Long){

        try {
            em.transaction.begin()

            val product = em.find(Product::class.java, id)

            if (product != null){
                em.remove(product)
                println("The product was removed successfully!")
            }
            em.transaction.commit()
        }
        catch (e: Exception){
            em.transaction.rollback()
            throw e
        }
        finally {
            em.close()
        }



    }

    fun modifyProductName(id: Long, newName: String){

        try {
            em.transaction.begin()

            val product = em.find(Product::class.java, id)

            if (product != null){
                product.name = newName
                em.merge(product)
                println("The product was renamed successfully!")
            }
            em.transaction.commit()
        }
        catch (e: Exception){
            em.transaction.rollback()
            throw e
        }
        finally {
            em.close()
        }
    }

    fun modifyProductStock(id: Long, newStock: Int){

        try {
            em.transaction.begin()

            val product = em.find(Product::class.java, id)

            if (product != null){
                product.stock = newStock
                em.merge(product)
                println("The product stock was updated!")
            }
            em.transaction.commit()
        }
        catch (e: Exception){
            em.transaction.rollback()
            throw e
        }
        finally {
            em.close()
        }
    }

    fun getProduct(id: Long): Product?{
        return em.find(Product::class.java, id)
    }

    fun getProductsWithStock(): List<Product>{
        val query = em.createQuery("SELECT p FROM Product p WHERE p.stock > 0", Product::class.java)
        return query.resultList // <-- devuelve los resultados de la query
    }

    fun getProductsWithoutStock(): List<Product>{
        val query = em.createQuery("SELECT p FROM Product p WHERE p.stock = 0", Product::class.java)
        return query.resultList
    }
}