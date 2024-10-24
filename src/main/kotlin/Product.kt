package org.example

import jakarta.persistence.*
import java.util.*


@Entity
@Table
data class Product(

    val category: String,

    val name: String,

    val desc: String,

    val priceNoIVA: Float,

    val priceIVA: Float,

    val dateRegister: Date,

    val stock: Int,

    val provider: Provider,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long)
