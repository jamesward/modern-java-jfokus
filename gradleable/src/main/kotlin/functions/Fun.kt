package functions

fun clip(s: String): String {
    return s.take(4)
}

fun up(s: String): String = s.uppercase()

val clipUp = { s: String -> up(clip(s)) }

fun main() {
    println(clipUp("a"))
    println(clipUp("abcdef"))
}