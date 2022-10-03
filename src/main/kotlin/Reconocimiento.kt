import java.util.*

class Reconocimiento(fecha: Date, cuadrante: Int, var area_reconocer: Int, var cosa_encontrada: String = "", var resumen_orden: String = "") : Ordenes(fecha, cuadrante) {
    fun resumen_orden(): String {
        if (cosa_encontrada != ""){
            return "El area ha sido explorada"
        } else{
            return "El area aun no ha sido explorada"
        }
    }
}

