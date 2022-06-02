package com.nicomahnic.embeddedroomexample


import androidx.lifecycle.LiveData

class MyRepository(private val myDao: MyDao) {

    val readPerson: LiveData<List<Person>> = myDao.readPerson()

    fun readPersonByStreetName(streetName: String) : LiveData<List<Person>> {
        return myDao.readPersonByStreetName(streetName)
    }

    suspend fun insertPerson(person: Person){
        myDao.insertPerson(person)
    }

}