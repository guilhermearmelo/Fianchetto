package com.guilhermearmelo.fianchetto.domain.entity

import com.guilhermearmelo.fianchetto.domain.enums.File
import com.guilhermearmelo.fianchetto.domain.enums.Rank

class Board {

    private val positions = Array(8) { arrayOfNulls<Square>(8) }

    init {
        for (i in 1..8) {
            for (j in 1..8) {
                positions[i - 1][j - 1] = Square(File.fromId(j), Rank.fromId(i))
            }
        }
    }

    fun getPositions(): Array<Array<Square?>> {
        return positions
    }

    fun showPositions() {
        for (i in 7 downTo 0) {
            for (j in 0..7) {
                print(positions[i][j]!!.getSquareName() + " ")
            }
            println()
        }
    }
}
