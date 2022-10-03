import java.util.Calendar
import kotlin.random.Random

object Factoria {
    fun crearCuadrantes(drones: Array<Dron?>, i: Int, j: Int) = Cuadrantes(drones, "Jack $i $j", "Vika $i $j", ArrayList())
    fun crearOrdenReparacion(cuadrante: Int, dron: Dron) =
        Reparacion(Calendar.getInstance().time, cuadrante, dron.num_dron)
    fun crearOrdenExploracion(cuadrante: Int, area: Int) =
        Reconocimiento(Calendar.getInstance().time,cuadrante, area);
}