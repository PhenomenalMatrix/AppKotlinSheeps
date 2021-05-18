package com.example.appkotlinsheeps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rv.view.*

class Adapter2 : RecyclerView.Adapter<Adapter2.ViewHolder>() {
    private var list: ArrayList<Int> = arrayListOf()

    fun addist(list: ArrayList<Int>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return Adapter2.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(i: Int) {
            itemView.img_view.setImageResource(i)
        }

    }
}