package com.shubham.shopcheck

import android.R.layout.simple_list_item_1
import android.R.layout.simple_list_item_multiple_choice
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shubham.shopcheck.Dbhelper.Companion.ITEM_NAME
import com.shubham.shopcheck.Dbhelper.Companion.ITEM_TABLE_NAME
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener
{

    companion object
    {
        lateinit var dbhelper: Dbhelper
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchView.requestFocus()

        dbhelper = Dbhelper(this)
        val shoplist = ArrayList<String>()
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
        addbtn.setOnClickListener {

            if (additem.text.isEmpty())
            {
                Toast.makeText(this, "Please enter the item", Toast.LENGTH_SHORT).show()
                //additem.requestFocus()
            }
            else
            {
                val item = Itemdbclass()
                //var cursor = dbhelper
                val db = dbhelper.writableDatabase
                val cursor = db.rawQuery("select * from Itemdb",null)
                 //cursor= it
                item.itemsName = additem.text.toString()
                //MainActivity.dbhelper.itemadd(this, item)
                val search = findViewById<SearchView>(R.id.searchView)
                val listview: ListView = findViewById<ListView>(R.id.listview)
                //val cursor
                ///////////////////
                // while (cursor.moveToNext()) {
                //  }

                    while (cursor.moveToNext())
                    {
                        shoplist.add(additem.getText().toString())
                        break
                    }

                val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, simple_list_item_1, shoplist)
                listview.adapter = arrayAdapter
                listview.choiceMode = ListView.CHOICE_MODE_SINGLE
                listview.onItemClickListener = this
                ClearEdit()
                searchView.requestFocus()
                search.setOnQueryTextListener(object : SearchView.OnQueryTextListener
                {
                    override fun onQueryTextSubmit(query: String?): Boolean
                    {
                        //search.clearFocus()
                        if (shoplist.contains(query))
                        {
                            arrayAdapter.filter.filter(query)
                        }
                        else
                        {
                            Toast.makeText(
                                applicationContext,
                                "Item is not on database, add explicitly",
                                Toast.LENGTH_LONG
                            ).show()
                            additem.requestFocus()
                        }
                        searchView.requestFocus()
                        return false
                        //ClearEdit()
                        // additem.requestFocus()
                    }
                    override fun onQueryTextChange(querry: String?): Boolean
                    {
                        arrayAdapter.filter.filter(querry)
                        return false
                    }
                })
            }
        }
    }
    private fun ClearEdit()
    {
        additem.text.clear()
    }
    override fun onResume()
    {

        super.onResume()
    }
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
    {
        val itemdy: String = parent?.getItemAtPosition(position) as String
        //Toast.makeText(this, "$itemdy", Toast.LENGTH_SHORT).show()
        //SparseBooleanArray checked:Boolean = listview.getItemAtPosition(position)

        /** HERE I NEED TO CREATE A NEW ARRAYLIST OF THE CHECKEDITEM IN THE LIST VIEW **/
        val select= ArrayList<String>()



                select.add(itemdy)
                //select.add("kutata")




                selectbtn.setOnClickListener {

                    val intent = Intent(this, Main2Activity::class.java)
                    /**HERE I AM SENDING TI T0 NEXT ACTIVITY**/
                    intent.putStringArrayListExtra("listOfSelectedItems", select)
                    startActivity(intent)

                }

    }
}






