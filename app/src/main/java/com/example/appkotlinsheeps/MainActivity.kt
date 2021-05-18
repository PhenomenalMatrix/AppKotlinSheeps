package com.example.appkotlinsheeps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Adapter.OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private var list: ArrayList<Int> = arrayListOf()
    private var list2: ArrayList<Int> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.add(R.drawable.ic_launcher_background)
        list.add(R.drawable.ic_launcher_background)
        list.add(R.drawable.ic_launcher_background)
        list.add(R.drawable.ic_launcher_background)
        list.add(R.drawable.ic_launcher_background)
        list.add(R.drawable.ic_launcher_background)
        list.add(R.drawable.ic_launcher_background)

        recyclerView = recycler_view
        recyclerView.layoutManager = GridLayoutManager(this,3)
        adapter = Adapter()
        adapter.addist(list,this)
        recyclerView.adapter = adapter
        btn_send.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            intent.putIntegerArrayListExtra("key",list2)
            startActivity(intent)
        }

    }

    override fun addOnClick(imageView: Int) {
        list2.add(imageView)
        Toast.makeText(this,list2.size.toString(),Toast.LENGTH_SHORT).show()
    }

    override fun removeOnClick(imageView: Int) {
        if (list2.size > 0) {
            list2.removeAt(imageView-1)
            Toast.makeText(this,list2.size.toString(),Toast.LENGTH_SHORT).show()
        }
    }
}