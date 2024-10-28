package org.example.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "users")
data class User(

    @Column(name = "password", nullable = false)
    val password: Int,

    @Id
    val name: String)
