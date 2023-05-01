package com.guilhermearmelo.fianchetto.domain.entity

import com.guilhermearmelo.fianchetto.domain.enums.Color
import com.guilhermearmelo.fianchetto.domain.enums.File
import com.guilhermearmelo.fianchetto.domain.enums.Rank

data class Queen(
    var position: Square,
    var color: Color
) : Piece() {
    private var possibleMovementsSet = mutableSetOf<Square>()

    override fun possibleMovements() {
        val rank = position.rank.ordinal + 1
        val file = position.file.ordinal + 1

        for (i in 0..8) {
            possibleMovementsSet.add(Square(this.position.rank, File.fromId(i + 1)))
            possibleMovementsSet.add(Square(Rank.fromId(i + 1), this.position.file))
        }

        for (i in 1..8) {
            addMovementIfValid(rank + i, file + i)
            addMovementIfValid(rank - i, file - i)
            addMovementIfValid(rank + i, file - i)
            addMovementIfValid(rank - i, file + i)
        }

        possibleMovementsSet.remove(Square(position.rank, position.file))
    }

    private fun addMovementIfValid(rank: Int, file: Int) {
        if (rank in 1..8 && file in 1..8) {
            possibleMovementsSet.add(Square(Rank.fromId(rank), File.fromId(file)))
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
