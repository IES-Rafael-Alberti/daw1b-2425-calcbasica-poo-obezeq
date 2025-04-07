package app

import service.Calculadora
import ui.Consola

class Aplicacion {

    private val consola = Consola()
    private val calculadora = Calculadora()

    fun ejecutar() {
        var continuar = true

        while (continuar) {

            try {

                println("\n───────────────────────────")
                println("        CALCULADORA        ")
                println("───────────────────────────\n")

                val num1 = consola.leerNumero("[+] Ingrese primer número: ")
                val operador = consola.leerOperador("[+] Ingrese operación (+, -, *, /): ")
                val num2 = consola.leerNumero("[+] Ingrese segundo número: ")

                val resultado = calculadora.calcular(num1, num2, operador)
                consola.mostrarResultado(resultado)

                continuar = preguntarRepetir()

            } catch (e: Exception) {

                consola.mostrarError(e.message ?: "[-] Error desconocido")
                continuar = preguntarRepetir()

            }

        }

        println("\n[+] PROGRAMA FINALIZADO CON EXITO, ADIOS!")

    }

    private fun preguntarRepetir(): Boolean {
        print("\n[?] ¿Desea realizar otra operación? (S/N): ")
        val respuesta = consola.scanner.next().trim().lowercase()
        if (respuesta == "s" || respuesta == "si" || respuesta == "y" || respuesta == "yes") {
            consola.refresh()
            return true
        } else {
            return false
        }
    }
}