package org.example.entities

import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "products")
data class Product(

    @Column
    val name: String,

    val desc: String,

    val priceNoIVA: Float,

    val priceIVA: Float,

    val dateRegister: Date,

    val stock: Int,

    @ManyToOne
    @JoinColumn(name = "id_provider")
    val provider: Provider?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?
) {
    constructor(): this("","",0f,0f,Date(),0,null,null)
}
