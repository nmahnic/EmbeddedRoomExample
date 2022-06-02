package com.nicomahnic.embeddedroomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.persistableBundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : MyAdapter
    private lateinit var myViewModel: MyViewModel
    private var personList: MutableList<Person> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        adapter = MyAdapter(personList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            var address = Address("Sesame Street", 10)
            var person = Person(0, "John", "Doe", 25, address)
            myViewModel.insertPerson(person)

            address = Address("Av. San Isidro Labrador", 4471)
            person = Person(0, "Nicolás", "Mahnic", 27, address)
            myViewModel.insertPerson(person)
        }

        btnReadAll.setOnClickListener {
            myViewModel.readPerson.observe(this) { it ->
                personList.clear()
                it.forEach { person ->
                    personList.add(person)
                    adapter.notifyDataSetChanged()
                }
            }
        }

        btnRead.setOnClickListener {
            myViewModel.readPersonByStreetName("Av. San Isidro Labrador").observe(this) { it ->
                personList.clear()
                it.forEach { person ->
                    personList.add(person)
                    adapter.notifyDataSetChanged()
                }
            }
        }


    }
}