package es.iesra.datos

import es.iesra.dominio.Reserva

/**
 * Implementación en memoria del repositorio de reservas.
 */
class ReservaRepository(private val DAO: DAO<Reserva>) : IReservaRepository {

    override fun obtenerTodas(): List<Reserva> = DAO.read()
    fun findById(id: Int) = DAO.read().find { it.id == id }
    fun register(reserva: Reserva) = DAO.create(reserva)
    fun <T> findByCustom(criteria: (Reserva) -> Boolean) = DAO.read().find(criteria)
    fun delete(reserva: Reserva) = DAO.delete(listOf(reserva))
    fun deleteAllIn(reservas: List<Reserva>) = DAO.delete(reservas)
}