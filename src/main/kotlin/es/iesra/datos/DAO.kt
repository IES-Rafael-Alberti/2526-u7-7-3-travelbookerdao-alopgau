package es.iesra.datos


interface DAO <T> {
    fun create(reserva: T)
    fun read(criteria: (T) -> Boolean): T?
    fun update(criteria: (T) -> Boolean, newDesc: String?, newUbi: String?, newNights: Int?)
    fun parseFile(): List<T>
    fun delete(criteria: (T) -> Boolean)
}