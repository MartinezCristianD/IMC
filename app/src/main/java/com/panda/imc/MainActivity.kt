package com.panda.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var weigth: Double = 0.0
    private var high: Double = 0.0
    private var noOp = " Error"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restar: Button = findViewById(R.id.restar)
        restar.setOnClickListener { resall() }

        val result: Button = findViewById(R.id.boton)
        result.setOnClickListener { resultImc() }
    }

    private fun resultImc() {
        val resultView = findViewById<TextView>(R.id.resultView)
        weigth = findViewById<EditText>(R.id.weigth).text.toString().toDouble()
        high = findViewById<EditText>(R.id.high).text.toString().toDouble()
        high /= 100.0
        high *= high

        when (val oper = (weigth / high).toFloat()) {
            in 0.0..18.4 -> {resultView.text = "Alerta!!Desnutricion su IMC es:$oper"}
            in 18.5..24.9 -> {resultView.text = "Felicitaciones su IMC es:$oper "}
            in 25.0..29.9 -> {resultView.text = "Alerta!! Obesidad su IMC es :$oper"}
            in 30.0..40.0 -> {resultView.text = "Consulte su EPS su IMC es :$oper"}
            else -> {resultView.text = noOp}
        }
    }

    private fun resall() {
        weigth= 0.0
        high = 0.0
        resultView.text = getString(R.string.app_name)
    }


}







