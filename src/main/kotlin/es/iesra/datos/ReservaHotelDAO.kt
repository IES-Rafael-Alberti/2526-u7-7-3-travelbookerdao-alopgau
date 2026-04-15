package es.iesra.datos

import es.iesra.dominio.ReservaHotel
import java.io.File

data class ReservaHotelDAO(
    private val file: File
): DAO<ReservaHotel> {


    override fun create(reserva: ReservaHotel) = file.appendText("${reserva.id},${reserva.descripcion},${reserva.ubicacion},${reserva.numeroNoches}")

    override fun read(reserva: ReservaHotel ): ReservaHotel? {
        val lines = file.readLines()
        val linesMap = lines.map {
            val lineSplit = it.split(",")
        ReservaHotel.recuperaInstancia(lineSplit[0].toInt(),lineSplit[1],lineSplit[2],lineSplit[3].toInt())
        }
        return linesMap.find(criteria)

        }

    override fun update(criteria: (String) -> Boolean, newDesc: String?, newUbi: String?, newNights: String?) {
        val fileLines = file.readLines().toMutableList()
        val target = fileLines.find(criteria)
        val targetIndex = fileLines.indexOf(target)
        if (target != null) {
            val targetSplitted = target.split(",")
            fileLines[targetIndex] = "${targetSplitted[0]},${newDesc ?: targetSplitted[1]},${newUbi ?: targetSplitted[2]},${newNights ?: targetSplitted[3]}"

            fileLines.forEach {file.writeText(it)}
        }

    }
    override fun delete(criteria: (String) -> Boolean) =  File("travelbooker.csv").readLines().filter(criteria)
}
    }
