package org.example.entities

import jakarta.persistence.*

@Entity
@Table(name = "providers")
data class Provider(

    @Column(name = "name")
    val name: String,

    @Column(name = "adress")
    val dir: String,

    @OneToMany(mappedBy = "provider")
    val product: List<Product>?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?){

    constructor(): this("", "", null, null)
}
