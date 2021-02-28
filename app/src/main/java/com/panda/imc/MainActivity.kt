package com.panda.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
      private var weigth: Double = 0.0
      private var high: Double = 0.0
      private var noOp = " Error"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val result: Button = findViewById(R.id.boton)
        result.setOnClickListener{resultImc()}
    }
        private fun resultImc() {
            val resultView=findViewById<TextView>(R.id.resultView)
            weigth = findViewById<EditText>(R.id.weigth).toString().toDouble()
            high= findViewById<EditText>(R.id.high).toString().toDouble()

                if (high in 10.0..250.0 && weigth in 10.0..150.0){
                resultView.text = (weigth / (high * high)).toString()
               } else {resultView.text= noOp }
        }
}
