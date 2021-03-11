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
    private lateinit var result: Button
    private lateinit var restar: Button
    private lateinit var highView: EditText
    private lateinit var weigthView: EditText
    lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = intent.extras!!.getString("name" )!!

        weigthView=findViewById(R.id.weigth)
        highView=findViewById(R.id.high)

        restar= findViewById(R.id.restar)
        restar.setOnClickListener { resall() }

        result = findViewById(R.id.boton)
        result.setOnClickListener { resultImc() }
    }

    private fun resultImc() {

        val resultView = findViewById<TextView>(R.id.resultView)
        weigth = weigthView.text.toString().toDouble()
        high = highView.text.toString().toDouble()
        high /= 100.0
        high *= high



        when (val oper = (weigth / high).toFloat()) {
            in 0.0..18.4 -> {resultView.text = "$name Alerta!!Desnutricion su IMC es:$oper"}
            in 18.5..24.9 -> {resultView.text = "$name Felicitaciones su IMC es:$oper "}
            in 25.0..29.9 -> {resultView.text = "$name Alerta!! Obesidad su IMC es :$oper"}
            in 30.0..40.0 -> {resultView.text = "$name Consulte su EPS su IMC es :$oper"}
            else -> {resultView.text = noOp}
        }
    }

    private fun resall() {
        weigthView.text.clear()
        highView.text.clear()
        resultView.text = getString(R.string.app_name)
    }
}
