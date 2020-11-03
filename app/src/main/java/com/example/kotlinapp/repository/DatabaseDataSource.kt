package com.example.kotlinapp.repository

import androidx.lifecycle.LiveData
import com.example.kotlinapp.data.db.dao.PersonDAO
import com.example.kotlinapp.data.db.entity.PersonEntity

class DatabaseDataSource(private val personDAO: PersonDAO) : PersonRepository {

    override suspend fun insertPerson(name: String, email: String, telefone: String, nascimento:String, cpf: String): Long {
        val person = PersonEntity(
            nome = name,
            email = email,
            telefone = telefone,
            nascimento= nascimento,
            cpf = cpf
        )
        return personDAO.insert(person)
    }

    override suspend fun updatePerson(id: Long, name: String, email: String, telefone: String, nascimento:String, cpf: String) {
        val person = PersonEntity(
            id = id,
            nome = name,
            email = email,
            telefone = telefone,
            nascimento= nascimento,
            cpf = cpf
        )

        personDAO.update(person)
    }

    override suspend fun deletePerson(id: Long) {
        personDAO.delete(id)
    }

    override suspend fun deleteAllPerson() {
        personDAO.deleteAll()
    }

    override suspend fun getAllPerson(): LiveData<List<PersonEntity>> {
        return personDAO.getAll()
    }
}