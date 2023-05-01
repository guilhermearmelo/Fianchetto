package com.guilhermearmelo.fianchetto.domain.enums

enum class File {
    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H;

    companion object {
        fun fromId(id: Int): File {
            return when (id) {
                1 -> A
                2 -> B
                3 -> C
                4 -> D
                5 -> E
                6 -> F
                7 -> G
                else -> H
            }
        }
    }
}
