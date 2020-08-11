package com.shubham.shopcheck

import android.content.ClipData
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.FontsContract
import android.widget.Toast

class Dbhelper (context: Context) :SQLiteOpenHelper(context, "ITEMDATABASE", null,1)
{
    companion object {
        val ITEM_TABLE_NAME="Itemdb"
        val ITEM_NAME="Item"
    }
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_ITEM_TABLE: String =("CREATE TABLE $ITEM_TABLE_NAME (" +" $ITEM_NAME TEXT)")
        db?.execSQL(CREATE_ITEM_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    fun getItem(nCtx:Context): ArrayList<Itemdbclass>
    {
        val qry="SELECT * FROM $ITEM_TABLE_NAME"
        val db = this.readableDatabase
        val cursor= db.rawQuery(qry ,null)
        val items = ArrayList<Itemdbclass>()
        if(cursor.count==0)
        {
            Toast.makeText(nCtx, "No Item Found", Toast.LENGTH_LONG).show()
        }
        else{
            while(cursor.moveToNext()){
                val item= Itemdbclass()
                item.itemsName=cursor.getString(cursor.getColumnIndex(ITEM_NAME))
                items.add(item)
            }

        }
        cursor.close()
        db.close()
        return items
    }
    fun itemadd(nCtx: Context, itemdbclass: Itemdbclass ){
        val value= ContentValues()
        value.put(ITEM_NAME, itemdbclass.itemsName)
        val db=this.writableDatabase
        try {
            db.insert(  ITEM_TABLE_NAME, null, value)
            //db.rawQuerry("INSERT INTO $ITEM_TABLE_NAME ($ITEM_NAME) VALUES(?)")
            Toast.makeText(nCtx,"Item added to database", Toast.LENGTH_SHORT).show()

        } catch (e : Exception)
        {
            Toast.makeText(nCtx," Something wrong", Toast.LENGTH_LONG).show()
        }
    }

}