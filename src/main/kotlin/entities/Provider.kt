package org.example.entities

import jakarta.persistence.*

@Entity
@Table(name = "providers")
data class Provider(

    @Column
    val name: String,

    val dir: String,

    @ManyToOne
    val product: List<Product>,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?)
