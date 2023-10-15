package com.example.bmi

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)
        Log.d("ResultActivity", "Height : $height, Weight : $weight")
        val bmi =  weight / (height / 100.0).pow(2.0)
        val resultMessage = when {
            bmi >= 35.0 -> "SUPER OBESITY"
            bmi >= 30.0 -> "MORBID OBESITY"
            bmi >= 25.0 -> "SEVERE OBESITY"
            bmi >= 23.0 -> "OVERWEIGHT"
            bmi >= 18.5 -> "NORMAL"
            else -> "UNDERWEIGHT"
        }
        val roundOff = String.format("%.2f", bmi)
        val bmiValueTextview = findViewById<TextView>(R.id.bmiValue)
        val resultMessageTextView = findViewById<TextView>(R.id.resultMessage)
        val backButton = findViewById<Button>(R.id.backBtn)

        bmiValueTextview.text = roundOff
        resultMessageTextView.text = resultMessage
        backButton.setOnClickListener {
            onBackPressed()
        }


    }


}