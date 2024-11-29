package br.com.geometry.api.controller


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.awt.Stroke


// classes base
data class Cubo( val lado: Double)
data class Esfera( val raio: Double)
data class Cilindro ( val raio: Double, val altura: Double)
data class Prisma ( val base: Double, val altura: Double)

data class Resposta(val area: Int, val perimetro: Int, val volume: Int)

@RestController
@RequestMapping("/api")
class GeometryController {

    @PostMapping("/cubo")
    fun calculateCubo(@RequestBody cubo: Cubo ): ResponseEntity<Any> {
        val volume = (Math.pow(cubo.lado, 3.0)).toInt()
        val area = (6 * Math.pow(cubo.lado, 2.0)).toInt()
        val perimetro = (12 * cubo.lado).toInt()
        return ResponseEntity.status(HttpStatus.CREATED).body(Resposta(area, perimetro, volume))
    }
    
    @PostMapping("/esfera")
    fun calculateEsfera(@RequestBody esfera: Esfera): ResponseEntity<Any> {
        val volume = (4/3 * Math.PI * Math.pow(esfera.raio, 3.0)).toInt()
        val area = (4 * Math.PI * Math.pow(esfera.raio, 2.0)).toInt()
        return ResponseEntity.status(HttpStatus.OK).body(Resposta(area, 0, volume))
    }

    @PostMapping("/cilindro")
    fun calculateCilindro(@RequestBody cilindro: Cilindro): ResponseEntity<Any> {
        val volume = (Math.PI * Math.pow(cilindro.raio, 2.0) * cilindro.altura).toInt()
        val area = (2 * Math.PI * cilindro.raio * (cilindro.raio + cilindro.altura)).toInt()
        return ResponseEntity.status(HttpStatus.CREATED).body(Resposta(area, 0, volume))
    }

    @PostMapping("/prisma")
    fun calculatePrisma(@RequestBody prisma: Prisma): ResponseEntity<Any> {
        val volume = (prisma.base * prisma.altura).toInt()
        val area = (2 * prisma.base + 2 * prisma.altura).toInt()
        val perimetro = (4 * prisma.base + 4 * prisma.altura).toInt()
        return ResponseEntity.status(HttpStatus.CREATED).body(Resposta(area, perimetro, volume))
    }
}