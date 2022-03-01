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

fun main() {

  val hello = Hello()

  hello.subscribe({ println("Text: $it")})
  hello.subscribe({ println("Agora vai: $it")})

  println("Hello world")

  hello.publish("Testando")
}
