package es.iesra.datos
import es.iesra.dominio.ReservaHotel
import es.iesra.dominio.ReservaVuelo
import java.io.File
 class ReservaVueloDAO(private val file: File): DAO<ReservaVuelo> {
    override fun create(reserva: ReservaVuelo) = file.appendText("${reserva.id},${reserva.descripcion},${reserva.origen},${reserva.destino}, ${reserva.horaVuelo}\n")
     override fun read(): List<ReservaVuelo> {
         val lines = file.readLines()
         val linesMap = lines.map {
             val lineSplit = it.split(",")
             ReservaVuelo.recuperaInstancia(lineSplit[0].toInt(),lineSplit[1],lineSplit[2],lineSplit[3], lineSplit[4])
         }
         return linesMap
     }

     override fun update(
     {
         val lines = parseFile().toMutableList()

         val target = lines.find(criteria)
         if (target != null) {
             val targetIdx = lines.indexOf(target)
             lines[targetIdx] = ReservaVuelo.recuperaInstancia(target.id, "${newDesc ?: target.descripcion}", "${newUbi ?: target.ubicacion}", newNights ?: target.numeroNoches)
         }
         file.writeText("")
         lines.forEach {reserva -> file.appendText("${reserva.id},${reserva.descripcion},${reserva.ubicacion},${reserva.numeroNoches}\n") }
     }

}