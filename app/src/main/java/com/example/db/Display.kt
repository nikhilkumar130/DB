package com.example.db

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.display.*

class Display : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display)
        var helper=dbhelper(this)
        var db=helper.readableDatabase
        var  list=ArrayList<data>()
        var rs=db.rawQuery("SELECT * FROM USER",null)
        while (rs.moveToNext()){
            val email=rs.getColumnIndex("EMAIL")
            val fname=rs.getColumnIndex("FIRSTNAME")
            val lname=rs.getColumnIndex("LASTNAME")
            val number=rs.getColumnIndex("MOBILE")
            val password=rs.getColumnIndex("PASSWORD")
            val n=data(rs.getString(email).toString(),rs.getString(fname).toString(),rs.getString(lname).toString(),rs.getString(number).toString(),rs.getString(password))
            list.add(n)
//            list.add(data(rs.getString(email).toString(),rs.getString(fname).toString(),rs.getString(lname).toString(),rs.getString(number).toString(),rs.getString(password)))
            var adap=Adapter(list)
            recyclerView.adapter=adap
        }
        accept.setOnClickListener {
            startActivity(Intent(this,acceptedUsers::class.java))
        }


    }
}