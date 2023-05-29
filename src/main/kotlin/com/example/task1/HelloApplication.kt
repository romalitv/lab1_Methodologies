package com.example.task1

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import kotlin.math.sqrt

fun main(args: Array<String>) {

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

    val D = (index[1] * index[1] - 4 * index[0] * index[2]).toDouble()
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