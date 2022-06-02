package com.nicomahnic.embeddedroomexample

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MyDao {

    @Query("SELECT * FROM my_table ORDER BY id ASC")
    fun readPerson(): LiveData<List<Person>>

    @Query("SELECT * FROM my_table WHERE streetName IN (:streetName)")
    fun readPersonByStreetName(streetName: String): LiveData<List<Person>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: Person)

}