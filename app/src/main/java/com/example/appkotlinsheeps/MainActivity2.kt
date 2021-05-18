package com.example.appkotlinsheeps

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val list = intent.getIntegerArrayListExtra("key")
        recyclerView = rv2
        recyclerView.layoutManager = GridLayoutManager(this,3)
        adapter = Adapter2()
        list?.let { adapter.addist(it) }
        recyclerView.adapter = adapter
        Log.e("TAG", "onCreate: "+list?.get(0) )
    }
}