package org.example.entities

import jakarta.persistence.*

@Entity
@Table(name = "suppliers")
data class Supplier(

    @Column(name = "name")
    val name: String,

    @Column(name = "adress")
    val dir: String,

    @OneToMany(mappedBy = "supplier")
    val product: List<Product>?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?){

    constructor(): this("", "", null, null)
}
