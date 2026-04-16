package es.iesra.datos

import es.iesra.dominio.Reserva
import es.iesra.dominio.ReservaHotel
import es.iesra.dominio.ReservaVuelo

/**
 * Implementación en memoria del repositorio de reservas.
 */
class ReservaRepository(private val hotelDAO: DAO<ReservaHotel>, private val flightDAO: DAO<ReservaVuelo>) : IReservaRepository {

    override fun obtenerTodas(): List<Reserva> = hotelDAO.read().toSet().union(flightDAO.read()).toList()
    override fun findById(id: Int): Reserva? {
    val flightSearch = flightDAO.read().find { it.id == id }
    if (flightSearch == null){
        val hotelSearch = hotelDAO.read().find { it.id == id }
        if (hotelSearch == null) return null else return hotelSearch
    } else {
        return flightSearch
    }
    }

    override fun register(reserva: Reserva) {
        when (reserva) {
            is ReservaHotel -> hotelDAO.create(reserva)
            is ReservaVuelo -> flightDAO.create(reserva)
            else -> ""

        }
    }


    override fun delete(reserva: Reserva) {
        when (reserva) {
            is ReservaHotel -> hotelDAO.delete(reserva)
            is ReservaVuelo -> flightDAO.delete((reserva))
            else -> ""
    }
    }

    override fun deleteAllIn(reservas: List<Reserva>) {
       reservas.forEach { reserva -> when (reserva) {
           is ReservaHotel -> hotelDAO.delete(reserva)
           is ReservaVuelo -> flightDAO.delete((reserva))
           else -> ""
       } }
    }
}