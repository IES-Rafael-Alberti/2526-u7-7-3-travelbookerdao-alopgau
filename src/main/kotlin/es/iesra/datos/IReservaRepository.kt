package es.iesra.datos

import es.iesra.dominio.Reserva

/**
 * Interfaz que define las operaciones básicas para almacenar y recuperar reservas.
 */
interface IReservaRepository {
    fun obtenerTodas(): List<Reserva>
}
