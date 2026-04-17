package es.iesra.datos
import es.iesra.dominio.ReservaHotel
import es.iesra.dominio.ReservaVuelo
import java.io.File
 class ReservaVueloDAO(): DAO<ReservaVuelo> {
     private val file = File("travelbooker_vuelos.csv")
    override fun create(reserva: ReservaVuelo) {
            val lines = file.readLines().toMutableList()
            val target = lines.find {
                val lineSplit = it.split(",")
                (lineSplit[0].toIntOrNull()?:-1 == reserva.id)
            }
        if (target == null) {
            file.appendText("${reserva.id},${reserva.descripcion},${reserva.origen},${reserva.destino},${reserva.horaVuelo}\n")
        } else {
            val targetIdx = lines.indexOf(target)
            lines[targetIdx] = "${reserva.id},${reserva.descripcion},${reserva.origen},${reserva.destino},${reserva.horaVuelo}\n"
            file.writeText("")
            lines.forEach { file.appendText(it) }
        }
    }
     override fun read(): List<ReservaVuelo> {
         val lines = file.readLines()
         if (lines[0].isEmpty()) return emptyList()
         val linesMap = lines.map {
             val lineSplit = it.split(",")
             ReservaVuelo.recuperaInstancia(lineSplit[0].toInt(),lineSplit[1],lineSplit[2],lineSplit[3], lineSplit[4])
         }
         return linesMap
     }
     override fun delete(reservaABorrar: ReservaVuelo) {
         val lines = read()
         val reservasFiltradas = lines.filter { it.id != reservaABorrar.id }
         file.writeText("")
         reservasFiltradas.forEach { reserva -> file.appendText("${reserva.id},${reserva.descripcion},${reserva.origen},${reserva.destino}, ${reserva.horaVuelo}\n") }
     }

 }
