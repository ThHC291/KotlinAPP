package com.example.kotlinapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe

import com.example.kotlinapp.R
import com.example.kotlinapp.data.db.AppDatabase
import com.example.kotlinapp.data.db.dao.PersonDAO
import com.example.kotlinapp.extension.hideKeyboard
import com.example.kotlinapp.repository.DatabaseDataSource
import com.example.kotlinapp.repository.PersonRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.person_fragment.*

class PersonFragment : Fragment(R.layout.person_fragment) {

    private val viewModel: PersonViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val subscriberDAO: PersonDAO =
                    AppDatabase.getInstance(requireContext()).subscriberDAO

                val repository: PersonRepository= DatabaseDataSource(subscriberDAO)
                return PersonViewModel(repository) as T
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeEvents()
        setListeners()
    }

    private fun observeEvents() {
        viewModel.personStateEventData.observe(viewLifecycleOwner) { personState ->
            when (personState) {
                is PersonViewModel.PersonState.Inserted -> {
                    clearFields()
                    hideKeyboard()
                    requireView().requestFocus()
                }
            }
        }

        viewModel.messageEventData.observe(viewLifecycleOwner) { stringResId -> Snackbar.make(requireView(), stringResId, Snackbar.LENGTH_LONG).show() }
    }

    private fun clearFields() {
        input_name.text?.clear()
        input_email.text?.clear()
        input_telefone.text?.clear()
        input_nascimento.text?.clear()
        input_cpf.text?.clear()
    }

    private fun hideKeyboard() {
        val parentActivity = requireActivity()
        if (parentActivity is AppCompatActivity) {
            parentActivity.hideKeyboard()
        }
    }

    private fun setListeners() {
        button_person.setOnClickListener {
            val name = input_name.text.toString()
            val email = input_email.text.toString()
            val telefone = input_telefone.text.toString()
            val nascimento = input_nascimento.text.toString()
            val cpf= input_cpf.text.toString()

            viewModel.addPerson(name, email, telefone, nascimento, cpf)
        }
    }
}
