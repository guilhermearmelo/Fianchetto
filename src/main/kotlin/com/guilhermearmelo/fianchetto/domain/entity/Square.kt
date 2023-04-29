package com.guilhermearmelo.fianchetto.domain.entity

import com.guilhermearmelo.fianchetto.domain.enums.File
import com.guilhermearmelo.fianchetto.domain.enums.Rank

data class Square(
    var file: File,
    var rank: Rank
) {
    fun getSquareName(): String {
        return rank.name + (file.ordinal + 1).toString()
    }
}
