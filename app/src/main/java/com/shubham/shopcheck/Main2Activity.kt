package com.shubham.shopcheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.listdisplay.*

class Main2Activity : AppCompatActivity() {

    private lateinit var lv:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


       // MainActivity.dbhelper = Dbhelper(this)
        var reciveList= ArrayList<String>()
        reciveList= intent.getSerializableExtra("listOfSelectedItems") as ArrayList<String>
        val itemreceve=findViewById<ListView>(R.id.lv)

        val lvAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, reciveList )

        itemreceve.adapter=lvAdapter

        btnfinal.setOnClickListener {
            Toast.makeText(this, "Item has been Finalize!", Toast.LENGTH_SHORT).show()
        }
    }




}


