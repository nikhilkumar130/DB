package com.example.db

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Register.setOnClickListener {
            var intent=Intent(this,Registerr::class.java)
            startActivity(intent)
            finish()
        }
        Login.setOnClickListener {
            val email=Username.text.toString()
            val password=Password.text.toString()
            val checkbox=checkBox.isChecked
                if (email=="singarapunikhilkumar@gmail.com" && password=="qwertyuiop" && checkbox){
                    startActivity(Intent(this,Display::class.java))
                }else{
                    Toast.makeText(this, "fill the details", Toast.LENGTH_SHORT).show()
                }
        }
    }
}