package es.iesra.datos

interface DAO <T> {
    fun create()
    fun read(): T
    fun update()
    fun delete()
}