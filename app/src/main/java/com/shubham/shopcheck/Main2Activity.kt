package com.shubham.shopcheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.listdisplay.*

class Main2Activity : AppCompatActivity() {
    companion object {
        lateinit var dbhelper: Dbhelper
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        MainActivity.dbhelper = Dbhelper(this)

        viewItem()

    }


    fun viewItem() {
        val itemlist: ArrayList<Itemdbclass> = Main2Activity.dbhelper.getItem(this)
        val adapter = ItemAdapter(this, itemlist)
        val rv: RecyclerView = findViewById(R.id.rv)
        rv.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false) as RecyclerView.LayoutManager
        rv.adapter = adapter
    }

}


