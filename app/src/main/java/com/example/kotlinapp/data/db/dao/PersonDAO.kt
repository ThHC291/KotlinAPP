package com.example.kotlinapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kotlinapp.data.db.entity.PersonEntity

@Dao
interface PersonDAO {
    @Insert
    suspend fun insert(person: PersonEntity): Long

    @Update
    suspend fun update(person: PersonEntity)

    @Query("DELETE FROM person WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM person")
    suspend fun deleteAll()

    @Query("SELECT * FROM person")
    fun getAll(): LiveData<List<PersonEntity>>
}