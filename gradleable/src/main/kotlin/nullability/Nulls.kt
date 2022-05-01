package nullability

fun main() {
    val a: String = "asdf"
    val b: String? = null

    val i: Int = a.length
    val j: Int? = b?.length
}