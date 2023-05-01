package com.guilhermearmelo.fianchetto.domain.entity

import com.guilhermearmelo.fianchetto.domain.enums.Color
import com.guilhermearmelo.fianchetto.domain.enums.File
import com.guilhermearmelo.fianchetto.domain.enums.Rank

data class Rook(
    var position: Square,
    var color: Color
) : Piece() {
    private var possibleMovementsSet = mutableSetOf<Square>()
    override fun possibleMovements() {
        for (i in 0..8) {
            possibleMovementsSet.add(Square(File.fromId(i + 1), this.position.rank))
            possibleMovementsSet.add(Square(this.position.file, Rank.fromId(i + 1)))
        }
        possibleMovementsSet.remove(Square(this.position.file, this.position.rank))
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
