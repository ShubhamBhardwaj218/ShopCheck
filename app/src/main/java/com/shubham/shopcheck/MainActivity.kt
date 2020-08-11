package com.shubham.shopcheck

import android.R.layout.simple_list_item_1
import android.R.layout.simple_list_item_multiple_choice
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shubham.shopcheck.Dbhelper.Companion.ITEM_NAME
import com.shubham.shopcheck.Dbhelper.Companion.ITEM_TABLE_NAME
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    companion object{
        lateinit var dbhelper: Dbhelper
    }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dbhelper = Dbhelper(this)
        addbtn.setOnClickListener{
            if( additem.text.isEmpty())
            {
                Toast.makeText(this, "Please enter the item", Toast.LENGTH_SHORT ).show()
                additem.requestFocus()
            }
            else{

                var shoplist = ArrayList<String>()



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
                val item = Itemdbclass()
                var cursor= dbhelper
                item.itemsName= additem.text.toString()
                MainActivity.dbhelper.itemadd(this, item)
                val search = findViewById<SearchView>(R.id.searchView)
                val listview: ListView = findViewById<ListView>(R.id.listview)
                //////////////////////////
                //var itemName = additem.toString()

                   // while (cursor.moveToNext()) {

                  //  }
                    shoplist.add(additem.getText().toString())

                /////////////////////////
                val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, simple_list_item_multiple_choice, shoplist)
                listview.adapter = arrayAdapter
                listview.choiceMode=ListView.CHOICE_MODE_MULTIPLE
                listview.onItemClickListener=this
                ClearEdit()
                ///////////////////////

                additem.requestFocus()
                search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        search.clearFocus()
                        if (shoplist.contains(query)) {
                            arrayAdapter.filter.filter(query)
                        } else {
                            Toast.makeText(applicationContext, "Item is not on database, add explicitly", Toast.LENGTH_LONG).show()
                        }
                        return false
                        //ClearEdit()
                        additem.requestFocus()
                    }
                    override fun onQueryTextChange(querry: String?): Boolean {
                        arrayAdapter.filter.filter(querry)
                        return false

                    ///////////////////////




                }




       /* var search = findViewById<SearchView>(R.id.searchView)
        var listview: ListView = findViewById<ListView>(R.id.listview)*/

       /* val shoplist = ArrayList<String>()
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
        shoplist.add(" Mixtures")*/

        /*val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, simple_list_item_1, shoplist)
        listview.adapter = arrayAdapter
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search.clearFocus()
                if (shoplist.contains(query)) {
                    arrayAdapter.filter.filter(query)
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Item is not on database, add explicitly",
                        Toast.LENGTH_LONG
                    ).show()
                }
                return false
            }

            override fun onQueryTextChange(querry: String?): Boolean {
                arrayAdapter.filter.filter(querry)
                return false
            }

        })
        //dbhelper = Dbhelper(this)
        //viewItem()*/
    }
                )


         //fun viewItem()


            /*val itemlist : ArrayList<Itemdbclass> = dbhelper.getItem(this)
            val adapter= ItemAdapter(this, itemlist)
            val rv:RecyclerView= findViewById(R.id.rv)
            rv.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL , false) as RecyclerView.LayoutManager
            rv.adapter= adapter*/

        }
        }


    }
    private fun ClearEdit(){
        additem.text.clear()
    }
    override fun onResume() {

        super.onResume()
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var itemdy:String=parent?.getItemAtPosition(position) as String
        Toast.makeText(this, "$itemdy", Toast.LENGTH_SHORT).show()

    }
}



