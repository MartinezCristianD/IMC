package com.panda.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_blood_presure.*



class BloodPressure : AppCompatActivity() {

    private var systole: Double = 0.0
    private var diastole: Double = 0.0
    private lateinit var resultBp: Button
    private lateinit var restarBp: Button
    private lateinit var diastoleInput: EditText
    private lateinit var systoleInput: EditText
    lateinit var name: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blood_presure)

        name = intent.extras!!.getString("name")!!

        systoleInput = findViewById(R.id.systole)
        diastoleInput = findViewById(R.id.diastole)

        restarBp = findViewById(R.id.restarBp)
        restarBp.setOnClickListener { resallBp() }

        resultBp = findViewById(R.id.btnResultBp)
        resultBp.setOnClickListener { resultBp() }

    }

    private fun resultBp() {

        val resultViewBp = findViewById<TextView>(R.id.resultViewBp)
        if (!systoleInput.text.isNullOrEmpty()) {
            systole = systoleInput.text.toString().toDouble()
        }
        if (!diastoleInput.text.isNullOrEmpty()) {
            diastole = diastoleInput.text.toString().toDouble()
        }


        val hypotension = name + getString(R.string.hypotension)
        val normalBp = name + getString(R.string.normalBp)
        val elevated = name + getString(R.string.elevated)
        val hypertension = name + getString(R.string.hypertension)
        val hypertension2 = name + getString(R.string.hypertension2)

        when  {
            (systole in 40.0..79.9) && (diastole in 50.0..59.9)  -> {
                resultViewBp.text = hypotension
            }
            (systole in 80.0..120.9) && (diastole in 60.0..80.9) -> {
                resultViewBp.text = normalBp
            }
            (systole in 121.0..139.9) && (diastole in 81.0..88.9) -> {
                resultViewBp.text = elevated
            }
            (systole in 140.0..159.0) && (diastole in 90.9..99.9) -> {
                resultViewBp.text = hypertension
            }
            (systole in 160.0..180.0) && (diastole in 100.0..110.0) -> {
                resultViewBp.text = hypertension2
            }
            else -> {
                resultViewBp.text = getString(R.string.noOperation)
            }
        }

    }
    private fun resallBp() {
        diastoleInput.text.clear()
        systoleInput.text.clear()
        resultViewBp.text = getString(R.string.btnBp)
    }
}

