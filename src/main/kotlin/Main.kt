import java.time.LocalDate
import java.util.Calendar
import java.util.Date
import kotlin.random.Random

fun main() {
    var num_drones = 0
    var tierra = Tierra(Array(3) { Array(3) { null } })
    var tet = Tet(200, Array(200) { Dron(it, true) }, ArrayList())
    for (i in tierra.parrilla.indices) {
        for (j in tierra.parrilla[0].indices) {
            var random: Int = ((Math.random() * 3) + 1).toInt()
            var drones: Array<Dron?> = Array(random) { null }
            for (m in drones.indices) {
                num_drones++
                drones[m] = Dron(num_drones)
                tet.num_drones--
            }
            tierra.parrilla[i][j] = Factoria.crearCuadrantes(drones, i, j)
        }
    }

    var contador: Int = 1
    while (contador < 120) {
        if (contador % 4 == 0) {
            dron_roto(tierra)
        }
        if (contador % 10 == 0) {
            recorrer_planeta(tierra)
        }
        if (contador % 20 == 0) {
            resolucion_ordenes(tierra, tet)
        }
        contador++
        resumir(tierra)
    }

}

fun resolucion_ordenes(tierra: Tierra, tet: Tet) {
    remplazo_dron(tierra, tet)
    for (i in tierra.parrilla.indices) {
        for (j in tierra.parrilla[i].indices) {
            for (m in tierra.parrilla[i][j]?.ordenes?.indices!!) {
                val ordenes = tierra.parrilla[i][j]?.ordenes?.get(m)
                if (ordenes is Reparacion) {
                    ordenes.estado_operativo = true
                }

                if (ordenes is Reconocimiento) {

                    var random: Int = (Math.random() * (3 - 1) + 1).toInt();
                    if (random == 0) {
                        ordenes.cosa_encontrada = "Vegetal"
                    } else if (random == 1) {
                        ordenes.cosa_encontrada = "Animal"
                    } else if (random == 2) {
                        ordenes.cosa_encontrada = "Radiacion"
                    }
                }
            }
        }
    }

}

fun recorrer_planeta(tierra: Tierra) {
    for (i in tierra.parrilla.indices) {
        for (j in tierra.parrilla[0].indices) {
            for (m in tierra.parrilla[i][j]?.drones?.indices!!) {
                if (tierra.parrilla[i][j]?.drones?.get(m) != null) {
                    if (tierra.parrilla[i][j]!!.drones[m]!!.estaRoto()) {
                        tierra.parrilla[i][j]?.crearOrdenReparacion(i, j, m, tierra)
                    }
                }
                var num_explo: Int = (Math.random() * (10 - 5) + 5).toInt()
                var area: Int = (Math.random() * (20 - 1) + 1).toInt()
                for (k in 0..num_explo) {
                    tierra.parrilla[i][j]?.crearOrdenExploracion(j, area)
                }
            }
        }
    }
}

fun dron_roto(tierra: Tierra) {
    for (i in tierra.parrilla.indices) {
        for (j in tierra.parrilla[0].indices) {
            for (m in tierra.parrilla[i][j]?.drones?.indices!!) {
                if (tierra.parrilla[i][j]?.drones?.get(m) != null) {
                    tierra.parrilla[i][j]!!.drones[m]?.romperDron()
                }
            }
        }
    }


}

fun resumir(tierra: Tierra) {
    var total_tareas: Int = 0;
    for (i in tierra.parrilla.indices) {
        for (j in tierra.parrilla[i].indices) {
            for (m in tierra.parrilla[i][j]?.ordenes?.indices!!) {
                val orden = tierra.parrilla[i][j]?.ordenes?.get(m)
                if (orden is Reparacion) {
                    orden.resumen_orden()
                }
                if (orden is Reconocimiento) {
                    orden.resumen_orden()
                }
                if (tierra.parrilla[i][j]?.ordenes?.size!! > 0) {
                    total_tareas += tierra.parrilla[i][j]?.ordenes?.size!!
                }
            }
        }
    }
    println(total_tareas)


}

fun remplazo_dron(tierra: Tierra, tet: Tet) {
    for (i in tierra.parrilla.indices) {
        for (j in tierra.parrilla[0].indices) {
            for (m in tierra.parrilla[i][j]?.drones?.indices!!) {
                if (tierra.parrilla[i][j]?.drones?.get(m) != null) {
                    tierra.parrilla[i][j]!!.drones[m]?.remplazar_dron()
                    tet.num_drones--
                }
            }
        }
    }
    
}
