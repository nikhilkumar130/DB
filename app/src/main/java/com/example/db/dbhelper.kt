package com.example.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class dbhelper(context: Context) : SQLiteOpenHelper(context, "db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USER(EMAIL VARCHAR2,FIRSTNAME VARCHAR2,LASTNAME VARCHAR2,MOBILE VARCHAR2,PASSWORD VARCHAR2)")
        db?.execSQL("CREATE TABLE ACCEPTED_USERS(EMAIL VARCHAR2,FIRSTNAME VARCHAR2,LASTNAME VARCHAR2,MOBILE VARCHAR2,PASSWORD VARCHAR2)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}
