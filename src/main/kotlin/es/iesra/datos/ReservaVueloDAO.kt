package es.iesra.datos
import es.iesra.dominio.ReservaVuelo
data class ReservaVueloDAO(val id: String,
                           val descripcion: String,
                           val origen: String,
                           val destino: String,
                           val horaVuelo: String ): DAO<ReservaVuelo> {
    override fun create() =

    override fun read(): ReservaVuelo =

    override fun update() =

    override fun delete() =
}