fun main() {
    var num_drones = 0
    var tierra = Tierra(Array(3) { Array(3) { null } })
    var tet = Tet(200)
    for (i in tierra.parrilla.indices) {
        for (j in tierra.parrilla[0].indices) {
            var random: Int = ((Math.random() * 3) + 1).toInt()
            var drones: Array<Dron?> = Array(random) { null }
            for (m in drones.indices) {
                num_drones++
                drones[m] = Dron(num_drones)
                tet.num_drones--
            }
            tierra.parrilla[i][j] = Cuadrantes(drones, "Jack $i $j", "Vika $i $j")
        }
    }
}