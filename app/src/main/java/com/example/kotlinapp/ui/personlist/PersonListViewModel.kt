package com.example.kotlinapp.ui.personlist

import androidx.lifecycle.ViewModel
import com.example.kotlinapp.repository.PersonRepository

class PersonListViewModel(private val repository: PersonRepository) : ViewModel() {
    val allPersonsEvent = repository.getAllPerson()
}
