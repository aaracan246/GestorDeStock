package org.example

import jakarta.persistence.*

@Entity
@Table
data class Provider(

    @Column
    val name: String,

    val dir: String,

    val product: List<Product>,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?)
