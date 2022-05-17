package refraction

fun dont(o: Any): String {
    return when(o) {
        is String -> "str"
        is Boolean -> "bool"
        else -> "dunno"
    }
}

fun <T> aT(t: T): String {
    return "asdf"
}

data class Foo<T>(val t: T)

fun <T> fooT(foo: Foo<T>): String {
    return "fooT"
}

interface Bar {
    val name: String
}
data class MyBar(override val name: String) : Bar

fun <T : Bar> aBar(t: T): String {
    return t.name
}

fun <T : Comparable<T>> maxC(list: List<T>): T {
    return list.reduce { acc, t ->
        if (acc > t) acc else t
    }
}

fun main() {
    dont("asdf")
    dont(false)

    aT("asdf")
    aT(false)

    fooT(Foo("asdf"))
    fooT(Foo(false))

    //aBar("asdf")
    aBar(MyBar("asdf"))

    maxC(listOf(1, 2, 3))
}