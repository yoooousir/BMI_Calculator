package com.example.bmi_calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.bmi_calculator.R
import kotlin.math.pow
import kotlin.math.round

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        var value = weight / (height / 100.0).pow(2.0)
        value = round(value*10) / 10

        var resultText = ""
        var resImage = 0
        var resColor = 0

        if (value < 18.5) {
            resultText = "저체중"
            resImage = R.drawable.ic_level1
            resColor = Color.GREEN
        } else if (value >= 18.5 && value < 23.0) {
            resultText = "정상제충"
            resImage = R.drawable.ic_level2
            resColor = Color.BLUE
        } else if (value >= 23.0 && value < 25.0) {
            resultText = "과체중"
            resImage = R.drawable.ic_level3
            resColor = Color.BLACK
        } else if (value >= 25.0 && value < 30.0) {
            resultText = "경도 비만"
            resImage = R.drawable.ic_level4
            resColor = Color.MAGENTA
        } else if (value >= 30.0 && value < 35.0) {
            resultText = "중정도 비만"
            resImage = R.drawable.ic_level5
            resColor = Color.RED
        } else {
            resultText = "고도비만"
            resImage = R.drawable.ic_level6
            resColor = Color.RED
        }


        val tvResValue = findViewById<TextView>(R.id.tv_resValue)
        val tvResText = findViewById<TextView>(R.id.tv_resText)
        val ivResImage = findViewById<ImageView>(R.id.iv_resImage)

        tvResValue.text = value.toString()
        tvResText.text = resultText

        tvResText.setTextColor(resColor)

        ivResImage.setImageResource(resImage)


        val submitButton = findViewById<Button>(R.id.btn_close)

        submitButton.setOnClickListener{
            finish()
        }
    }
}