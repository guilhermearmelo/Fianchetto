package com.guilhermearmelo.fianchetto.domain.entity

import com.guilhermearmelo.fianchetto.domain.enums.Color

abstract class Piece(
    private var position: Square,
    private var color: Color
) {
    abstract fun posibleMovements() : List<Square>
}