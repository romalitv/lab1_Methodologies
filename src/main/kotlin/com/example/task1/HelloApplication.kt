package com.example.task1

import javafx.scene.paint.Stop
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.Scanner
import kotlin.math.sqrt

fun main() {
    // Інтерактивний режим

        println("Enter between 1 and 2\n1 is for interactive mode, 2 is for noninteractive")
        val meth = readlnOrNull()?.toInt()

        println("You choose: $meth")

        if (meth != null && true) {
              if (meth.toInt() !== 1 && meth.toInt() !== 2) {
                      println("Choose number between 1 and 2")
                      return
               }
        }
        println(meth)
        when {
            meth == 1 -> interact()
            meth == 2 -> noninteract()
        }
}

fun interact() {
        val scanner = Scanner(System.`in`)

        println("Enter a:")
        val a = scanner.nextInt()
        println("Enter b:")
        val b = scanner.nextInt()
        println("Enter c:")
        val c = scanner.nextInt()

        AAAAAAAABBBBBBBCCCCCCCCCCDDDDDDDDDDDD

}
fun noninteract() {
        // Неінтерактивний режим
        val filename = "src/main/kotlin/com/example/task1/config.properties"
        val file = File(filename)
        // Перевірка існування файлу
        if(!file.exists()){
                println("Check is file is even in program")
        }

        val reader = BufferedReader(FileReader(file))
        val line = reader.readLine()
        val numbers = line.split(" ")
        val index = numbers.map { it.toDouble() }

        //Перевірка правильної кількості індексів a, b, c
        if(numbers.size != 3) {
                println("Error. invalid numbers of indexes")
                return
        }

        for ((index, value) in index.withIndex()) {
                println("Index $index = $value" )
        }

        println("Equation: (" + index[0] + ") * x^2 + (" + index[1] + ") * x + (" + index[2] + ")")

        val D = (index[1] * index[1] - 4 * index[0] * index[2])
        println("D = $D")

        if (D > 0.toDouble()) {
                val x1 = ((-index[1] + sqrt(D)) / 2 * index[0])
                val x2 = ((-index[1] - sqrt(D)) / 2 * index[0])
                println("x1 = $x1\nx2 = $x2\nThere are 2 roots")
        }

        if (D === 0.toDouble()) {
                val x = (-index[1] / 2 * index[0])
                println("x = $x\nThere are 1 root")
        }

        if(D < 0.toDouble()) {
                println("D < 0. Equation don't have roots as real numbers")
        }

        reader.close()
}