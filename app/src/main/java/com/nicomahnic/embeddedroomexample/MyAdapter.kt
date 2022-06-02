package com.nicomahnic.embeddedroomexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.row_layout.view.*

class MyAdapter(
    private var personList : MutableList<Person>
): RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MyViewHolder(layoutInflater.inflate(R.layout.row_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.render(personList[position])
    }

    override fun getItemCount(): Int = personList.size

    fun clear(){
        personList = mutableListOf()
        this.notifyDataSetChanged()
    }

}

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    fun render(person: Person){
        itemView.firstName_txt.text = person.firstName
        itemView.lastName_txt.text = person.lastName
        itemView.age_txt.text = person.age.toString()

        itemView.streetName_txt.text = person.address.streetName
        itemView.streetNumber_txt.text = person.address.streetNumber.toString()
    }
}