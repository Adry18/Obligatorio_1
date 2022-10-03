class Dron(var num_dron: Int, var operativo: Boolean = true) {
    fun romperDron() {
        var random: Int = (Math.random() * 100).toInt()
        if (random < 20) {
            operativo = false
        }
    }

    fun estaRoto(): Boolean {
        return !operativo
    }

    fun remplazar_dron() {
        operativo = true
    }
}