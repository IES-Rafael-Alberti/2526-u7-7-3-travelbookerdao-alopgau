package es.iesra.datos

import es.iesra.dominio.Reserva

/**
 * Interfaz que define las operaciones básicas para almacenar y recuperar reservas.
 */
interface IReservaRepository {
    fun obtenerTodas(): List<Reserva>
    fun findById(id: Int): Reserva?
    fun register(reserva: Reserva)
    fun delete(reserva: Reserva?)
    fun maxId(reservas: List<Reserva>): Int
}
