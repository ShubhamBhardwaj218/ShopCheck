package com.shubham.shopcheck

import android.R.layout.simple_list_item_1
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main.view.button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var search= findViewById<SearchView>(R.id.searchView)
        var listview:ListView = findViewById<ListView>(R.id.listview)

        val shoplist= ArrayList<String>()
        shoplist.add(" Rice Sona Massori")
        shoplist.add(" Sugar")
        shoplist.add(" Salt")
        shoplist.add(" Ghee")
        shoplist.add(" Milk")
        shoplist.add(" Butter")
        shoplist.add(" Apple")
        shoplist.add(" Mango")
        shoplist.add(" Pulses")
        shoplist.add(" Cerial")
        shoplist.add(" Water")
        shoplist.add(" Battery")
        shoplist.add(" Milk Nandani")
        shoplist.add(" Butter ")
        shoplist.add(" Cheese")
        shoplist.add(" Potato")
        shoplist.add(" Onion")
        shoplist.add(" Ginger")
        shoplist.add(" Garlic")
        shoplist.add(" Beans")
        shoplist.add(" Biscuit Marry Gold")
        shoplist.add(" Biscuit GoodDay")
        shoplist.add(" Kurkure")
        shoplist.add(" Mixtures")

        val arrayAdapter : ArrayAdapter<String> = ArrayAdapter(this, simple_list_item_1 , shoplist)
        listview.adapter= arrayAdapter
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                search.clearFocus()
                if (shoplist.contains(query))
                {
                    arrayAdapter.filter.filter(query)
                }
                else{
                    Toast.makeText(applicationContext,"Item is not on database, add explicitly", Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(querry: String?): Boolean {
                arrayAdapter.filter.filter(querry)
                return false
            }

        })
        var helper = Dbhelper(applicationContext)
        var db= helper.readableDatabase
        var rq = db.rawQuery("SELECT * FROM ITEM", null)
        if(rq.moveToNext())
            Toast.makeText(applicationContext,rq.getString(1) ,Toast.LENGTH_LONG).show()
        /*button.setOnClickListener {
            var cv= ContentValues()
            cv.put("ITEMNAME", editText2.text.toString())
            db.insert("ITEM", null, cv)
            editText2.setText("")
        }*/
    }
}
