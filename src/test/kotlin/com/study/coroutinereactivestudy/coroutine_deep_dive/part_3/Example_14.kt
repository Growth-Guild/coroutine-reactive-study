package com.study.coroutinereactivestudy.coroutine_deep_dive.part_3

private fun m(i: Int): Int {
    print("m $i ")
    return i * i
}

private fun f(i: Int): Boolean {
    print("f $i ")
    return i >= 10
}

fun main() {
    listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .map { m(it) }
        .find{ f(it) }
        .let { print("$it ") }

    println()

    sequenceOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .map { m(it) }
        .find { f(it) }
        .let { print("$it ") }

    println()
}
