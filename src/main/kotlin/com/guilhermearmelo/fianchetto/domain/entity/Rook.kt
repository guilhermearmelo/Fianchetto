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
        for ( i in 0..8) {
            possibleMovementsSet.add(Square(this.position.rank, File.fromId(i+1)))
            possibleMovementsSet.add(Square(Rank.fromId(i+1), this.position.file))
        }
        possibleMovementsSet.remove(Square(this.position.rank, this.position.file))
    }

    fun getPossibleMovements() : MutableSet<Square> {
        return possibleMovementsSet
    }

    fun printPossibleMovements() {
        for (square in possibleMovementsSet) {
            print(square.getSquareName() + " ")
        }
    }
}