import kotlin.random.Random

fun main() {

    while (true) {

        println("1 - Sorteio Simples")
        println("2 - Sorteio De Intervalos")
        println("0 - Para sair")

        val option = readLine()!!.trim().toInt()

        when (option) {
            0 -> {
                println("Saindo...")
                break
            }

            1 -> sorteioSimples()
            2 -> sorteioComposto()
            else -> println("Opção Invalida")
        }


    }


}

fun sorteioSimples() {
    var n1: Int = 0

    if (n1 == 0) {
        println("Sorteio Simples")
        println("Digite o máximo:")
        n1 = readLine()!!.trim().toInt() // Corrigido para modificar a variável existente
    }

    val historico = mutableListOf<Int>() // Inicializa a lista vazia

    while (true) { // Loop principal para permitir novos sorteios
        var result: Int

        do {
            result = (1..n1 + 1).random() // Gera um número aleatório entre 1 e n1
        } while (historico.contains(result)) // Garante que o número não esteja no histórico

        if(historico.size >= 5){
            historico.removeAt(0)
        }

        historico.add(result) // Adiciona o resultado ao histórico

        println(
            """
            Sorteando...
            Intervalo de valores:
            0 - $n1
            Histórico: $historico
            Número sorteado: $result
        """.trimIndent()
        )

        println("1 - Novo Sorteio")
        println("0 - Voltar")
        val option = readLine()!!.trim().toInt()

        when (option) {
            0 -> break // Sai do loop se a opção for 0
            1 -> continue // Continua para novo sorteio
            else -> println("Opção Inválida") // Trata opções inválidas
        }
    }
}

fun sorteioComposto() {

    println("Informe os intervalos do sorteio:")
    println("minimo:")
    val n1 = readLine()!!.trim().toInt()
    println("maximo:")
    val n2 = readLine()!!.trim().toInt()

    if (n2 <= n1) {
        println("O maximo deve ser maior que o minimo")
    } else {

        val result: Int = Random.nextInt(n1, n2 + 1)
        println(
            """
        Sorteando...
        Entervalo de valores:
        $n1 - $n2
         Número sorteado: $result
    """.trimIndent()
        )
    }

}

fun random(min: Int, max: Int): Int {
    return Random.nextInt(min, max + 1)
}