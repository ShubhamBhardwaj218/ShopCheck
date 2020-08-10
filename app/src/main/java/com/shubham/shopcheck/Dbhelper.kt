package com.shubham.shopcheck

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Dbhelper (context: Context) :SQLiteOpenHelper(context, "ITEMDB", null,1)
{
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE ITEM( ITEMNAME TEXT)")
        db?.execSQL("INSERT INTO ITEM(ITEMNAME) VALUES('BANANA')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}