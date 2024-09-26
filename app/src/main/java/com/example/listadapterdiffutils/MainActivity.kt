package com.example.listadapterdiffutils

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerview=findViewById<RecyclerView>(R.id.progermer_list)
        val adapter=ProgrammingAdapter()

        val p1=ProgrammingItem(0,"J","JAVA")
        val p2=ProgrammingItem(1,"C++","C++")
        val p3=ProgrammingItem(2,"Py","Python")
        val p4=ProgrammingItem(3,"K","Kotlin")

        adapter.submitList(listOf(p1,p2,p3,p4))
        recyclerview.layoutManager=LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        recyclerview.adapter=adapter

        Handler(Looper.getMainLooper()).postDelayed({
            val p3=ProgrammingItem(3,"K","Kotlin")
            val p5=ProgrammingItem(4,"A","Angular")
            val p6=ProgrammingItem(5,"B","BrightScript")
            val p7=ProgrammingItem(6,"C","C Programming")
            adapter.submitList(listOf(p3,p5,p6,p7))
        },4000)
    }
}