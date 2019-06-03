package com.example.kotlinlangplayground

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.kotlinlangplayground.logic.FlipFlopLogic
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val logic = FlipFlopLogic()
    lateinit var btnMatrix:Array<Array<Button>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMatrix = arrayOf(
            arrayOf(btn1, btn2, btn3, btn4),
            arrayOf(btn5, btn6, btn7, btn8),
            arrayOf(btn9, btn10, btn11, btn12),
            arrayOf(btn13,btn14,btn15, btn16)
        )

        for (xx:Int in 0..3) {
            for (yy:Int in 0..3) {
                btnMatrix[yy][xx].setOnClickListener { v -> onButtonClick(xx, yy) }
            }
        }

        logic.shuffle()
        updateButtons()
    }

    private fun updateButtons() {
        for (xx:Int in 0..3) {
            for (yy:Int in 0..3) {
//                btnMatrix[yy][xx].isEnabled = logic.isChecked(xx, yy) // FIXME: doesn't work as you will not be able to click on disabled button (so stuppid!)
                 btnMatrix[yy][xx].text = if (logic.isChecked(xx, yy))  "|" else "-"
            }
        }
    }

    private fun onButtonClick(x:Int, y:Int) {
        logic.action(x, y)
        updateButtons()
        if (logic.haveWon())
            Toast.makeText(this, "Have won!", Toast.LENGTH_SHORT).show()
    }
}

