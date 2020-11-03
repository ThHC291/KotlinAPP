package com.example.kotlinapp.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nome: String = "",
    val email: String = "",
    val telefone: String = "",
    val nascimento: String = "",
    val cpf: String = ""
)
