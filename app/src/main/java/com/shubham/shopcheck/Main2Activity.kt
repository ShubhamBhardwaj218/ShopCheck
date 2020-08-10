package com.shubham.shopcheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        viewItem()
    }
    fun viewItem()
    {
        val itemlist : ArrayList<Itemdb> = MainActivity.dbhelper.getItem(this)
        val adapter= ItemAdapter(this, itemlist)
        val rv: RecyclerView = findViewById(R.id.recyclerView)
        rv.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL , false) as RecyclerView.LayoutManager
        rv.adapter= adapter
    }
}
