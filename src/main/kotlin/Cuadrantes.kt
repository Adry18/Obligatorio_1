class Cuadrantes(
    var drones: Array<Dron?>,
    var mecánico: String,
    var supervisora: String,
    var ordenes: ArrayList<Ordenes>
) {

    fun crearOrdenReparacion(i: Int, j: Int, m: Int, tierra: Tierra) {
        val ordenReparacion = Factoria.crearOrdenReparacion(j, tierra.parrilla[i][j]?.drones?.get(m)!!)
        ordenes.add(ordenReparacion)
    }

    fun crearOrdenExploracion(j: Int, area: Int) {
        var ordenExploracion = Factoria.crearOrdenExploracion(j, area)
        ordenes.add(ordenExploracion)
    }
}