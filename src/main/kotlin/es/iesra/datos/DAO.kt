package es.iesra.datos


interface DAO <T> {
    fun create(reserva: T)
    fun read(): List<T>
    fun delete(reservaABorrar: T)
}