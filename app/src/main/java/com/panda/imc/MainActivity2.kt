package com.panda.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity2 : AppCompatActivity() {
    lateinit var name:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        name = findViewById<EditText>(R.id.editTextTextPersonName).text.toString()



        val activity2 = findViewById<Button>(R.id.activity2)
        activity2.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("name",name)
            startActivity(intent)
        }


    }
}


