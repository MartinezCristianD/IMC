package com.panda.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class Begining : AppCompatActivity() {
    lateinit var name: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.begining)


        name = findViewById(R.id.TextPersonName)


        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", name.text.toString())
            startActivity(intent)
        }

        val bloodPressure = findViewById<Button>(R.id.btnCalcularBp)
        bloodPressure.setOnClickListener {
            val intent2 = Intent(this, BloodPressure::class.java)
            intent2.putExtra("name", name.text.toString())
            startActivity(intent2)
        }

    }
}


