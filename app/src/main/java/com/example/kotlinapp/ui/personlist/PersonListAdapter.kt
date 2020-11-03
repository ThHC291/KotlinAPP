package com.example.kotlinapp.ui.personlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.R
import com.example.kotlinapp.data.db.entity.PersonEntity

//class PersonListAdapter : RecyclerView.Adapter<PersonListAdapter.PersonListViewHolder>(){
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonListViewHolder{
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.person_item, parent, false)
//
//        return PersonListViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: PersonListViewHolder, position: Int) {
//        //holder.bindView(persons[position])
//    }

//    override fun getItemCount(): Int = subscribers.size
//
//    class PersonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val textViewSubscriberName: TextView = itemView.text_person_name
//        private val textViewSubscriberEmail: TextView = itemView.text_subscriber_email
//
//        fun bindView(subscriber: PersonEntity) {
//            textViewSubscriberName.text = subscriber.name
//            textViewSubscriberEmail.text = subscriber.email
//        }
//    }
//
//    }
//}