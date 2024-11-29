package br.unicamp.br.aula020524

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Aula020524Application

fun main(args: Array<String>) {
	runApplication<Aula020524Application>(*args)
	setBannerMode(Banner.Mode.OFF)
}
