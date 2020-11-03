package com.example.kotlinapp.ui.personlist

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController

import com.example.kotlinapp.R
import com.example.kotlinapp.data.db.AppDatabase
import com.example.kotlinapp.data.db.dao.PersonDAO
import com.example.kotlinapp.data.db.entity.PersonEntity
import com.example.kotlinapp.repository.DatabaseDataSource
import com.example.kotlinapp.repository.PersonRepository
import com.example.kotlinapp.ui.PersonViewModel
import kotlinx.android.synthetic.main.person_list_fragment.*

class PersonListFragment : Fragment(R.layout.person_list_fragment) {

    private val viewModel: PersonListViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val subscriberDAO: PersonDAO =
                    AppDatabase.getInstance(requireContext()).subscriberDAO

                val repository: PersonRepository = DatabaseDataSource(subscriberDAO)
                return PersonListViewModel(repository) as T
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModelEvents()
        configureViewListeners()
    }

    private fun observeViewModelEvents() {
        viewModel.allPersonsEvent.observe(viewLifecycleOwner) { allPersons ->
            val personListAdapter = PersonListAdapter(allPersons)
            recycler_persons.run {
                setHasFixedSize(true)
                adapter = personListAdapter
            }
        }
    }

    private fun configureViewListeners() {
        fabAddPerson.setOnClickListener {
            findNavController().navigate(R.id.personFragment)
        }
    }
}
