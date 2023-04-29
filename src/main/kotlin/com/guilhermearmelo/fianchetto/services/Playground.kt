package com.guilhermearmelo.fianchetto.services

import com.guilhermearmelo.fianchetto.domain.entity.Board
import com.guilhermearmelo.fianchetto.domain.entity.Rook
import com.guilhermearmelo.fianchetto.domain.entity.Square
import com.guilhermearmelo.fianchetto.domain.enums.Color
import com.guilhermearmelo.fianchetto.domain.enums.File
import com.guilhermearmelo.fianchetto.domain.enums.Rank
import org.springframework.stereotype.Service

@Service
class Playground() {
    fun runPlayground() {
        var board = Board()
        var rook = Rook(Square(Rank.E, File.FOUR), Color.BLACK)

        println()
        board.showPositions()
        rook.possibleMovements()
        println()
        rook.printPossibleMovements()
    }
}
