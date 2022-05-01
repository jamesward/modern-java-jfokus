data class Foo(val bars: ArrayList<String> = arrayListOf()) {
    fun bar(name: String) {
        bars.add(name)
    }
}

data class Fancy(var name: String?, var foo: Foo?) {
    fun name(s: String) {
        name = s
    }

    fun foo(init: Foo.() -> Unit): Foo {
        val f = Foo()
        f.init()
        foo = f
        return f
    }
}

fun fancy(init: Fancy.() -> Unit): Fancy {
    val f = Fancy(null, null)
    f.init()
    return f
}

val myFancy = fancy {
    name("hello")

    foo {
        bar("asdf")
        bar("zxcv")
    }
}

fun main() {
    println(myFancy)
    println(myFancy.copy(name = "test"))
}