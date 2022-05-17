package adt

data class Foo(val name: String)

fun main() {
    val f = Foo("asdf")
    println(f.copy(name = "zxcv"))
}