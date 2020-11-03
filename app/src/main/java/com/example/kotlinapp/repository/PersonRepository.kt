package com.example.kotlinapp.repository

import androidx.lifecycle.LiveData
import com.example.kotlinapp.data.db.entity.PersonEntity

interface PersonRepository {
    suspend fun insertPerson(name: String, email: String, telefone: String, nascimento:String, cpf: String): Long

    suspend fun updatePerson(id: Long, name: String, email: String, telefone: String, nascimento:String, cpf: String)

    suspend fun deletePerson(id: Long)

    suspend fun deleteAllPerson()

    fun getAllPerson(): LiveData<List<PersonEntity>>
}