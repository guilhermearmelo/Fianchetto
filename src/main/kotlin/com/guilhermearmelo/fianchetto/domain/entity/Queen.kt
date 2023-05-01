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
            possibleMovementsSet.add(Square(File.fromId(i + 1), this.position.rank))
            possibleMovementsSet.add(Square(this.position.file, Rank.fromId(i + 1)))
        }

        for (i in 1..8) {
            addMovementIfValid(file + i, rank + i)
            addMovementIfValid(file - i, rank - i)
            addMovementIfValid(file + i, rank - i)
            addMovementIfValid(file - i, rank + i)
        }

        possibleMovementsSet.remove(Square(position.file, position.rank))
    }

    private fun addMovementIfValid(rank: Int, file: Int) {
        if (rank in 1..8 && file in 1..8) {
            possibleMovementsSet.add(Square(File.fromId(file), Rank.fromId(rank)))
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
