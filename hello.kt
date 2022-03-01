class Hello {
  private val callbacks = mutableListOf<(String) -> Unit>()

  public fun subscribe(func: (String) -> Unit): Unit {
    callbacks.add(func)
  }

  public fun publish(text: String) {
    callbacks.forEach {
      it(text)
    }
  }

}

fun testString(ts: String): Unit {
  (0..10).iterator().forEach {
    println("$it: $ts")
  }
}

fun main() {

  val hello = Hello()

  hello.subscribe {
    println("Text: $it")
  }
  hello.subscribe { println("Agora vai: $it") }
  hello.subscribe({ println("Com parentesis: $it")})
  hello.subscribe(::testString)

  println("Hello world")

  hello.publish("Testando")
}
