package es.iesra.datos

import es.iesra.dominio.Reserva

/**
 * Implementación en memoria del repositorio de reservas.
 */
class ReservaRepository : IReservaRepository {

    override fun obtenerTodas(): List<Reserva> = reservas.toList()
}