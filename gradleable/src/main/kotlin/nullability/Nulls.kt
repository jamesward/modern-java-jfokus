package nullability

import kotlin.random.Random

fun main() {
    val a: String = "asdf"
    val b: String? = if (Random.nextBoolean()) null else "zxcv"

    val i: Int = a.length
    val j: Int? = b?.length

    if (j != null) {
        val z = j + 0
        println("$z was not null")
    }
}