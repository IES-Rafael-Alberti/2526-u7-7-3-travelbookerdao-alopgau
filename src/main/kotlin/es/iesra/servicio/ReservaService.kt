package es.iesra.servicio

import es.iesra.datos.IReservaRepository
import es.iesra.dominio.ReservaHotel
import es.iesra.dominio.ReservaVuelo

/**
 * Implementación concreta de IReservaService.
 * Depende de la abstracción IReservaRepository, no de una implementación concreta.
 */
class ReservaService(private val repositorio: IReservaRepository) : IReservaService {

    override fun crearReservaVuelo(descripcion: String, origen: String, destino: String, horaVuelo: String) {
       ReservaVuelo.contador = repositorio.maxId(repositorio.obtenerTodas().filter { it.id % 2 == 1 })
        val reservaVuelo = ReservaVuelo.creaInstancia(descripcion, origen, destino, horaVuelo)
        repositorio.register(reservaVuelo)
    }

    override fun crearReservaHotel(descripcion: String, ubicacion: String, numeroNoches: Int) {
        ReservaHotel.contador = repositorio.maxId(repositorio.obtenerTodas().filter { it.id % 2 == 0 })
        val reservaHotel = ReservaHotel.creaInstancia(descripcion, ubicacion, numeroNoches)
        repositorio.register(reservaHotel)
    }

    override fun listarReservas() = repositorio.obtenerTodas()
    override fun borrarReserva(id: Int) {
        repositorio.delete(repositorio.findById(id))
    }
}