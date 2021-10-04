package com.example.db

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_registerr.*

class Registerr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var helper = dbhelper(this)
        val db = helper.readableDatabase
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registerr)
        val array = arrayOf("Admin", "Employee")
        submit.setOnClickListener {
            var username = Uname.text.toString()
            var firstname = Fname.text.toString()
            var lastname = Lname.text.toString()
            var mobilename = Mnumber.text.toString()
            var password = Pword.text.toString()
            var cpassword = confirmPword.text.toString()


            if (username.isEmpty() && firstname.isEmpty() && lastname.isEmpty() && mobilename.isEmpty() && password.isEmpty() && cpassword.isEmpty() && password == cpassword) {
                Toast.makeText(this, R.string.empty, Toast.LENGTH_SHORT).show()
            } else {
                var cv = ContentValues()
                cv.put("EMAIL", username)
                cv.put("FIRSTNAME", firstname)
                cv.put("LASTNAME", lastname)
                cv.put("MOBILE", mobilename)
                cv.put("PASSWORD", password)
                db.insert("USER", null, cv)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
    }
}