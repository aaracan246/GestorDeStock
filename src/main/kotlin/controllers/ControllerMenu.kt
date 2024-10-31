package org.example.controllers

import jakarta.persistence.EntityManager
import org.example.repository.ProductRepository
import org.example.repository.SupplierRepository

class ControllerMenu(val em: EntityManager, private val pR: ProductRepository, private val prR: SupplierRepository) {

    private fun printMenu(){

        println("\n--- Options menu ---")
        println("1. Register a product")
        println("2. Deregister a product")
        println("3. Modify product name")
        println("4. Modify stock of a product")
        println("5. Search product (ID)")
        println("6. Search product with stock (ID)")
        println("7. Search product without stock (ID)")
        println("8. Search provider")
        println("9. Provider's list")
        println("0. Exit")
        print("Please, choose an option: ")
    }

    fun menu(){

        printMenu()
        while (true){
            printMenu()
            when (readln().toInt()) {

                1 -> {
                    val product = pR.askProdData()
                    pR.registerProduct(product)
                }

                2 -> {
                    println("Please, insert the ID of the product you want to remove: ")
                    val inputID = readln().toLong()
                    pR.deregisterProduct(inputID)
                }

                3 -> {
                    println("Please, insert the ID of the product: ")
                    val inputID = readln().toLong()

                    println("Please, insert a new name for the product: ")
                    val inputNewName = readln()
                    pR.modifyProductName(inputID, inputNewName)
                }

                4 -> {
                    println("Please, insert the ID of the product: ")
                    val inputID = readln().toLong()

                    println("Please, insert a new stock number for the product: ")
                    val inputStock = readln().toInt()
                    pR.modifyProductStock(inputID, inputStock)

                }

                5 -> {
                    println("Please, insert the ID of the product: ")
                    val inputID = readln().toLong()
                    val product = pR.getProduct(inputID)
                    println("The product ${product?.id}:\n name: ${product?.name}\n desc: ${product?.desc}\n price(no IVA): ${product?.priceNoIVA}\n price(IVA): ${product?.priceIVA}\n date: ${product?.dateRegister}\n stock: ${product?.stock}")
                }

                6 -> {
                    val productList = pR.getProductsWithStock()
                    println(productList)
                }

                7 -> {
                    val productList = pR.getProductsWithoutStock()
                    println(productList)
                }

                8 -> {
                    val supplier = prR.getSupplierProd()
                    println(supplier)
                }

                9 -> {
                    val supplier = prR.getAllSuppliers()
                    println(supplier)
                }

                0 -> {
                    println("Exiting...")
                    em.close()
                    break
                }
                else -> println("Not a valid option. Please select a valid one: ")
            }
        }
    }
}