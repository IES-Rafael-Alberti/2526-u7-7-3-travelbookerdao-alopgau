package es.iesra.datos

import es.iesra.dominio.ReservaHotel
import java.io.File

 class ReservaHotelDAO(
): DAO<ReservaHotel> {
    private val file = File("travelbooker_hoteles.csv")

    override fun create(reserva: ReservaHotel) {
        if ("${reserva.id},${reserva.descripcion},${reserva.ubicacion},${reserva.numeroNoches}" !in file.readLines()) {
        file.appendText("${reserva.id},${reserva.descripcion},${reserva.ubicacion},${reserva.numeroNoches}\n")
        } else {
         val lines = file.readLines().toMutableList()
         val target = lines.find {
             val lineSplit = it.split(",")
             (lineSplit[0].toInt() == reserva.id)
         }
         val targetIdx = lines.indexOf(target)
         lines[targetIdx] =  "${reserva.id},${reserva.descripcion},${reserva.ubicacion},${reserva.numeroNoches}"
            file.writeText("")
            lines.forEach { file.appendText(it) }

        }
    }

    override fun read(): List<ReservaHotel> {
        val lines = file.readLines()
        val linesMap = lines.map {
            val lineSplit = it.split(",")
        ReservaHotel.recuperaInstancia(lineSplit[0].toInt(),lineSplit[1],lineSplit[2],lineSplit[3].toInt())
        }
        return linesMap

        }

    override fun delete(reservaABorrar: ReservaHotel) {
        val lines = read()
        val reservasFiltradas = lines.filter { it != reservaABorrar }
        file.writeText("")
        reservasFiltradas.forEach { reserva -> file.appendText("${reserva.id},${reserva.descripcion},${reserva.ubicacion},${reserva.numeroNoches}\n") }
    }

    }


