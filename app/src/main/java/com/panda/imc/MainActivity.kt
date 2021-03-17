package com.panda.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.String as String

class MainActivity : AppCompatActivity() {
    private var weigth: Double = 0.0
    private var high: Double = 0.0
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

        result = findViewById(R.id.btnResult)
        result.setOnClickListener {resultImc()}
    }

    private fun resultImc() {

        val resultView = findViewById<TextView>(R.id.resultView)
        if (!weigthView.text.isNullOrEmpty()) {
           weigth = weigthView.text.toString().toDouble()
        }
        if (!highView.text.isNullOrEmpty()) {
            high = highView.text.toString().toDouble()
        }
        high /= 100.0
        high *= high
        val oper = (weigth / high).toFloat()
        val malnutrition = name + getString(R.string.malnutrition) + oper
        val normal = name + getString(R.string.normal) + oper
        val obesity = name + getString(R.string.obesity) + oper
        val eps = name +getString(R.string.eps) + oper

        when (oper) {
            in 0.0..18.4  -> {resultView.text  = malnutrition}
            in 18.5..24.9 -> {resultView.text = normal}
            in 25.0..29.9 -> {resultView.text = obesity}
            in 30.0..40.0 -> {resultView.text = eps}
            else -> {resultView.text = getString(R.string.noOperation)}
        }
    }

    private fun resall() {
        weigthView.text.clear()
        highView.text.clear()
        resultView.text = getString(R.string.app_name)
    }
}
