package com.example.kotlinlangplayground.logic

import kotlin.random.Random

class FlipFlopLogic {
    private val width = 3
    private val height = 3

    private val state:Array<BooleanArray> = arrayOf(
        booleanArrayOf(false, false, false, false),
        booleanArrayOf(false, false, false, false),
        booleanArrayOf(false, false, false, false),
        booleanArrayOf(false, false, false, false)
        )

    fun haveWon():Boolean {
        for (xx in state) {
            for (yy in xx) {
                if (yy == false)
                    return false
            }
        }

        return true;
    }

    fun isChecked(x:Int, y:Int):Boolean = state[x][y]

    fun shuffle() {
        val r = Random
        for (i in 0.. (3 + r.nextInt(17))) {
            val x = r.nextInt(width)
            val y = r.nextInt(height)
            action(x, y)
        }
    }

    // inverts state of one element
    private fun toggle(x:Int, y:Int) {
        state[x][y] = !state[x][y];
    }

    fun action(x:Int, y:Int) {
        for (xx in 0 until width)
            toggle(xx, y)
        for (yy in 0 until width)
            toggle(x, yy)
        toggle(x, y)
    }

    fun haveWon2(): Boolean {
        return state.all { it.all { it } }
    }
}