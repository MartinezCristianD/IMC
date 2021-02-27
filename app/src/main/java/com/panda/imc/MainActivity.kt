package com.panda.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val high=findViewById<View>(R.id.high)as Double
    private val weigth=findViewById<View>(R.id.weigth)as Double
    private var opp=0.0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result: Button = findViewById(R.id.boton)
        result.setOnClickListener{resultImc()}
    }
        private fun resultImc() {
            if (this.high in 0.0..250.0 && weigth in 0.0..150.0) {
                opp = weigth / (this.high * this.high)
            } else {
                resultView.text = "error"
            }
        }
    }























     /*   showView = "0"
        val result: Button = findViewById(R.id.boton)
        result.setOnClickListener(resView())
    }
    private var high = findViewById<EditText>(R.id.high)
    private var weigth = findViewById<EditText>(R.id.weigth)
    private var showView = findViewById<TextView>(R.id.resultView).toString()


    private fun resView(): View.OnClickListener? {
        val altura = high.toString().toDouble()
        val peso = weigth.toString().toDouble()
        val oper = (peso / (altura * altura))
        showView = when (oper) {
            in 10.0..70.0 -> oper.toString()
            else -> "error"
        }
    }*/




