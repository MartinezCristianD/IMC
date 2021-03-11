package com.panda.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity2 : AppCompatActivity() {
    lateinit var name:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        name = findViewById(R.id.editTextTextPersonName)



        val activity2 = findViewById<Button>(R.id.activity2)
        activity2.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("name",name.text.toString())
            startActivity(intent)
        }


    }
}


