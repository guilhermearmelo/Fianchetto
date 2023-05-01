package com.guilhermearmelo.fianchetto

import com.guilhermearmelo.fianchetto.services.Playground
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FianchettoApplication

fun main(args: Array<String>) {
    runApplication<FianchettoApplication>(*args)
    Playground().runPlayground()
}
