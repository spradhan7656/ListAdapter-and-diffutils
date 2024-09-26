package com.example.listadapterdiffutils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * i have using the listadapter they have inbuilt Diffutils
 * i have to inplemented the listadapter they need the list and constructor pass Diffutil obj
 */
class ProgrammingAdapter:ListAdapter<ProgrammingItem,ProgrammingAdapter.ProgrammingViewHolder>(Diffutils()) {

    class ProgrammingViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name=view.findViewById<TextView>(R.id.name)
        val initial=view.findViewById<TextView>(R.id.initial)

        fun bind(item: ProgrammingItem){
            name.text=item.name
            initial.text=item.initial
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        val item=getItem(position)
        holder.bind(item)
    }

    class Diffutils:DiffUtil.ItemCallback<ProgrammingItem>(){

        /**
         * first the method check the both list are in same id or not
         * second method check the list item same or not
         */
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProgrammingItem,
            newItem: ProgrammingItem,
        ): Boolean {
            return oldItem == newItem
        }

    }
}