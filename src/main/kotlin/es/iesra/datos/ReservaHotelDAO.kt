package es.iesra.datos

import es.iesra.dominio.ReservaHotel
import java.io.File

data class ReservaHotelDAO(
    private val file: File
): DAO<ReservaHotel> {

    override fun create(reserva: ReservaHotel) = file.appendText("${reserva.id},${reserva.descripcion},${reserva.ubicacion},${reserva.numeroNoches}")

    override fun read(criteria: (ReservaHotel) -> Boolean): ReservaHotel? {
        val lines = file.readLines()
        val linesMap = lines.map {
            val lineSplit = it.split(",")
        ReservaHotel.recuperaInstancia(lineSplit[0].toInt(),lineSplit[1],lineSplit[2],lineSplit[3].toInt())
        }
        return linesMap.find(criteria)

        }

    override fun update(criteria: (ReservaHotel) -> Boolean, newDesc: String?, newUbi: String?, newNights: Int?) {
        val lines = parseFile().toMutableList()

        val target = lines.find(criteria)
        if (target != null) {
            val targetIdx = lines.indexOf(target)
            lines[targetIdx] = ReservaHotel.recuperaInstancia(target.id, "${newDesc ?: target.descripcion}", "${newUbi ?: target.ubicacion}", newNights ?: target.numeroNoches)
        }
        lines.forEach {reserva -> file.writeText( "${reserva.id},${reserva.descripcion},${reserva.ubicacion},${reserva.numeroNoches}") }



    }

    override fun delete(criteria: (ReservaHotel) -> Boolean) {
        val newList = parseFile().filter(!criteria)
    }
 override fun parseFile(): List<ReservaHotel> {
    val lines = file.readLines()
    val linesMap = lines.map {
        val lineSplit = it.split(",")
        ReservaHotel.recuperaInstancia(lineSplit[0].toInt(),lineSplit[1],lineSplit[2],lineSplit[3].toInt())
    }
     return linesMap
    }
}
