package com.example.kotlinapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinapp.repository.PersonRepository
import com.example.kotlinapp.R
import kotlinx.coroutines.launch

class PersonViewModel( private val repository: PersonRepository) : ViewModel() {

    private val _personStateEventData = MutableLiveData<PersonState>()
    val personStateEventData: LiveData<PersonState>
        get() = _personStateEventData

    private val _messageEventData = MutableLiveData<Int>()
    val messageEventData: LiveData<Int>
        get() = _messageEventData

    fun addPerson(name: String, email: String, telefone: String, nascimento:String, cpf:String) = viewModelScope.launch {
        try {
            val id = repository.insertPerson(name, email, telefone, nascimento, cpf)
            if(id > 0) {
                _personStateEventData.value = PersonState.Inserted
                _messageEventData.value = R.string.person_inserted_successfully
            }
        } catch (ex: Exception) {
            _messageEventData.value = R.string.person_error_to_insert
            Log.e(TAG, ex.toString())
        }
    }

    sealed class PersonState {
        object Inserted : PersonState()
    }

    companion object {
        private val TAG = PersonViewModel::class.java.simpleName
    }
}
