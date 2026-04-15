package es.iesra.datos
import es.iesra.dominio.ReservaVuelo
import java.io.File
 class ReservaVueloDAO(private val file: File): DAO<ReservaVuelo> {
    override fun create(reserva: ReservaVuelo) = file.appendText("${reserva.id},${reserva.descripcion},${reserva.origen},${reserva.destino}, ${reserva.horaVuelo}\n")
     override fun read(criteria: (ReservaVuelo) -> Boolean): ReservaVuelo? {
         TODO("Not yet implemented")
     }

     override fun update(
         criteria: (ReservaVuelo) -> Boolean,
         newDesc: String?,
         newUbi: String?,
         newNights: Int?
     ) {
         TODO("Not yet implemented")
     }

     override fun parseFile(): List<ReservaVuelo> {
         TODO("Not yet implemented")
     }

     override fun delete(criteria: (ReservaVuelo) -> Boolean) {
         TODO("Not yet implemented")
     }
}