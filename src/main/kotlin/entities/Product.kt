package org.example.entities

import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "products")
data class Product(

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    val desc: String,

    @Column(name = "price")
    val priceNoIVA: Float,

    @Column(name = "price_IVA")
    val priceIVA: Float,

    @Column(name = "date")
    val dateRegister: Date,

    @Column(name = "stock")
    var stock: Int,

    @ManyToOne
    @JoinColumn(name = "id_supplier")
    val supplier: Supplier?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?
) {
    constructor(): this("","",0f,0f,Date(),0,null,null)
}
