package org.example.controllers

class ControllerMenu {

    fun printMenu(){

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
        while (true){
            when (readln().toInt()) {
                1 -> {}
                2 -> {}
                3 -> {}
                4 -> {}
                5 -> {}
                6 -> {}
                7 -> {}
                8 -> {}
                9 -> {}
                0 -> {
                    println("Exiting...")
                    break
                }
                else -> println("Not a valid option. Please select a valid one: ")
            }
        }
    }
}