import java.util.Calendar

object Factoria {
    fun crearCuadrantes(drones: Array<Dron?>, i: Int, j: Int) = Cuadrantes(drones, "Jack $i $j", "Vika $i $j")
    fun crearOrdenReparacion(cuadrante: Int, dron: Dron) =
        Reparacion(Calendar.getInstance().time, cuadrante, dron.num_dron)
}