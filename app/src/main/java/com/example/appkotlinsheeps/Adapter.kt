package com.example.appkotlinsheeps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rv.view.*

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>(){

    private var list: ArrayList<Int> = arrayListOf()
    private lateinit var ItemClickListener: OnItemClickListener

    fun addist(list: ArrayList<Int>, onItemClickListener: OnItemClickListener){
        this.list.addAll(list)
        this.ItemClickListener = onItemClickListener
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false), ItemClickListener)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    class ViewHolder(
        itemView: View,
        var ItemClickListener: OnItemClickListener
    ): RecyclerView.ViewHolder(itemView) {
        var i: Int = 0
        fun onBind(imageView: Int) {
            itemView.img_view.setImageResource(imageView)
            itemView.setOnClickListener {
                when (i){
                    0 ->{
                        itemView.img_view.setImageResource(R.drawable.ic_launcher_foreground)
                        i++
                        ItemClickListener.addOnClick(imageView)
                    }

                    1 ->{
                        itemView.img_view.setImageResource(R.drawable.ic_launcher_background)
                        i--
                        ItemClickListener.removeOnClick(adapterPosition)
                    }
                }
            }
        }

    }

    interface OnItemClickListener{
        fun addOnClick(imageView: Int)
        fun removeOnClick(imageView: Int)
    }

}