import java.util.*

class Reparacion(fecha: Date, cuadrante: Int, var num_dron: Int, var estado_operativo: Boolean = false) : Ordenes(fecha, cuadrante) {

    fun resumen_orden(): String {
        if (estado_operativo){
            return "El dron se ha arreglado"
        } else{
            return "El dron aun no se ha arreglado"
        }
    }
}