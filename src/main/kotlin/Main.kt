import java.time.LocalDate
import java.util.Calendar
import java.util.Date

fun main() {
    var num_drones = 0
    var tierra = Tierra(Array(3) { Array(3) { null } })
    var tet = Tet(200)
    var agenda = ArrayList<Ordenes>()
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
            dron_roto(tierra, tet)
        }
        if (contador % 10 == 0) {
            recorrer_planeta(tierra, agenda)
        }
        contador++
    }

}

fun recorrer_planeta(tierra: Tierra, agenda: ArrayList<Ordenes>) {
    for (i in tierra.parrilla.indices) {
        for (j in tierra.parrilla[0].indices) {
            for (m in tierra.parrilla[i][j]?.drones?.indices!!) {
                if (tierra.parrilla[i][j]?.drones?.get(m) != null) {
                    if (tierra.parrilla[i][j]!!.drones[m]!!.operativo == false) {
                        var fecha: Date = Calendar.getInstance().time
                        agenda.add(Factoria.crearOrdenReparacion(j, tierra.parrilla[i][j]?.drones?.get(m)!!))
                    }
                }
            }
        }

    }

}

fun dron_roto(tierra: Tierra, tet: Tet) {
    for (i in tierra.parrilla.indices) {
        for (j in tierra.parrilla[0].indices) {
            for (m in tierra.parrilla[i][j]?.drones?.indices!!) {
                if (tierra.parrilla[i][j]?.drones?.get(m) != null) {
                    var random: Int = (Math.random() * 100).toInt()
                    if (random < 20) {
                        tierra.parrilla[i][j]!!.drones[m]!!.operativo = false;
                    }
                }
            }
        }
    }

}
