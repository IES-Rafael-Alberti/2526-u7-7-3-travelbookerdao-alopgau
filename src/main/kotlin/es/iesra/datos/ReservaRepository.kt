package es.iesra.datos

import es.iesra.dominio.Reserva
import es.iesra.dominio.ReservaHotel
import es.iesra.dominio.ReservaVuelo

/**
 * Implementación en memoria del repositorio de reservas.
 */
class ReservaRepository(private val hotelDAO: DAO<ReservaHotel>, private val flightDAO: DAO<ReservaVuelo>) : IReservaRepository {

    override fun obtenerTodas(): List<Reserva> = hotelDAO.read().toSet().union(flightDAO.read()).toList()
    override fun findById(id: Int) {
        DAO.read().find { it.id == id }

    }

    override fun register(reserva: Reserva) =
        DAO.create(reserva)
    override fun <T> findByCustom(criteria: (Reserva) -> Boolean) = DAO.read().find(criteria)
    override fun delete(reserva: Reserva) = DAO.delete(listOf(reserva))
    override fun deleteAllIn(reservas: List<Reserva>) = DAO.delete(reservas)
}