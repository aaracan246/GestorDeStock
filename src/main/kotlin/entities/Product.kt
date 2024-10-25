package org.example.entities

import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "products")
data class Product(

    @Column
    val category: String,

    val name: String,

    val desc: String,

    val priceNoIVA: Float,

    val priceIVA: Float,

    val dateRegister: Date,

    val stock: Int,

    @OneToMany
    val provider: Provider,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?)
