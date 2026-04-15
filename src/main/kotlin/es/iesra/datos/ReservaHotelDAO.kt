package es.iesra.datos

import es.iesra.dominio.ReservaHotel
import java.io.File

data class ReservaHotelDAO(
    val id: String,
    val descripcion: String,
    val ubicacion: String,
    val numeroNoches: String
): DAO<ReservaHotel> {
    override fun create() = File("travelbooker.csv").appendText("$id,$descripcion,$ubicacion,$numeroNoches")

    override fun read(criteria: (String) -> Boolean ): ReservaHotel? {
        val target = File("travelbooker.csv").readLines().find(criteria)
        if (target != null) {
        val targetSplitted = target.split(",")
        return ReservaHotel.recuperaInstancia(targetSplitted[0].toInt(),targetSplitted[1],targetSplitted[2],targetSplitted[3].toInt())
        }
        return null
    }

    override fun update(criteria: (String) -> Boolean, newDesc: String?, newUbi: String?, newNights: String?) {
        val f = File("travelbooker.csv").readLines().toMutableList()
        val target = f.find(criteria)
        val targetIndex = f.indexOf(target)
        if (target != null) {
            val targetSplitted = target.split(",")
            f[targetIndex] = "${targetSplitted[0]},${newDesc ?: targetSplitted[1]},${newUbi ?: targetSplitted[2]},${newNights ?: targetSplitted[3]}"

            f.forEach {File("travelbooker.csv").writeText(it)}
        }

    }
    override fun delete(criteria: (String) -> Boolean) =  File("travelbooker.csv").readLines().filter(criteria)
}