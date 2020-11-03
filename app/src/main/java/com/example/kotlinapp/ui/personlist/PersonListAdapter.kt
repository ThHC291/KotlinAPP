package com.example.kotlinapp.ui.personlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.R
import com.example.kotlinapp.data.db.entity.PersonEntity
import kotlinx.android.synthetic.main.person_item.view.*

class PersonListAdapter(
    private val persons: List<PersonEntity>
) : RecyclerView.Adapter<PersonListAdapter.PersonListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonListViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_item, parent, false)

        return PersonListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonListViewHolder, position: Int) {
        holder.bindView(persons[position])
    }

    override fun getItemCount(): Int = persons.size

    class PersonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewPersonName: TextView = itemView.text_person_nome
        private val textViewPersonEmail: TextView = itemView.text_person_email

        fun bindView(person: PersonEntity) {
            textViewPersonName.text = person.nome
            textViewPersonEmail.text = person.email
        }
    }

}