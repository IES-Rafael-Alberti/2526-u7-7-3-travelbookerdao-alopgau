package es.iesra.datos

import es.iesra.dominio.ReservaHotel

class ReservaHotelDAO(
    id: Int,
    descripcion: String,
    val ubicacion: String,
    val numeroNoches: Int
): DAO<ReservaHotel> {
    override fun create() =

    override fun read(): ReservaHotel =

    override fun update() =

    override fun delete() =
}