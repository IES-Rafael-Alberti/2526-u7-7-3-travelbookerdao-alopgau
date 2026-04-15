package es.iesra.datos

interface DAO <T> {
    fun create()
    fun read(criteria: (String) -> Boolean): T?
    fun update(criteria: (String) -> Boolean, newDesc: String?, newUbi: String?, newNights: String?)
    fun delete(criteria: (String) -> Boolean): List<String>
}