package com.nicomahnic.embeddedroomexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(application: Application): AndroidViewModel(application) {

    private val dao = MyDatabase.getDatabase(application).myDao()
    private val repository = MyRepository(dao)

    val readPerson: LiveData<List<Person>> = repository.readPerson

    fun readPersonByStreetName(streetName: String) : LiveData<List<Person>> {
        return repository.readPersonByStreetName(streetName)
    }

    fun insertPerson(person: Person){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertPerson(person)
        }
    }

}