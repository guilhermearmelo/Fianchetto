package com.guilhermearmelo.fianchetto.domain.enums

enum class File {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT;

    companion object {
        fun fromId(id: Int): File {
            return when (id) {
                1 -> ONE
                2 -> TWO
                3 -> THREE
                4 -> FOUR
                5 -> FIVE
                6 -> SIX
                7 -> SEVEN
                else -> EIGHT
            }
        }
    }
}
