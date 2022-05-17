package collections

val words = listOf("asdf", "zxcv")
val nums = listOf(1, 2, 3)

fun main() {
    val a = words.filter { it.contains('a') }
    val b = nums.map { it + 1 }
    val c = nums.fold(0) { acc, i -> acc + i }
    val d = nums.sum()
    val e = nums.maxOrNull()
    val f = nums.flatMap { i -> List(i) { i } }
}