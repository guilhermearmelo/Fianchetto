package com.guilhermearmelo.fianchetto.domain.entity

import com.guilhermearmelo.fianchetto.domain.enums.Color
import com.guilhermearmelo.fianchetto.domain.enums.File
import com.guilhermearmelo.fianchetto.domain.enums.Rank

data class King(
    var position: Square,
    var color: Color
) : Piece() {
    private var possibleMovementsSet = mutableSetOf<Square>()

    override fun possibleMovements() {

        val rank = position.rank.ordinal + 1
        val file = position.file.ordinal + 1

        for (r in -1..1) {
            for (f in -1..1) {
                if (r == 0 && f == 0) continue

                val newRank = rank + r
                val newFile = file + f

                if (newRank in 1..8 && newFile in 1..8) {
                    possibleMovementsSet.add(Square(File.fromId(newFile), Rank.fromId(newRank)))
                }
            }
        }
    }

    fun getPossibleMovements(): MutableSet<Square> {
        return possibleMovementsSet
    }

    fun printPossibleMovements() {
        for (square in possibleMovementsSet) {
            print(square.getSquareName() + " ")
        }
    }
}
