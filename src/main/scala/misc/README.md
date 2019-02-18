# Misc theory questions

**How does this code works?**
```scala
lazy val factorial: Stream[Long] = 1 #:: factorial.zipWithIndex.map {
  case (f, i) => f * (i + 1)
}
// factorial.take(5).toList = List(1, 1, 2, 6, 24)
```
**more specifically, how is the value of `factorial` at `factorial.zipWithIndex` updated?**

In Scala, operators end with ":" is right-associative, this means that `#::` is a method of `factorial...`. Class `Stream` doesn't have this method, it is from [ConsWrapper](cons_wrapper). There is an [implicit conversion][stream_to_cons_wrapper] from `Stream` to it.

Now in `ConsWrapper`, the 2nd part is passed by name so it is not evaluated immediately, hence the laziness. When a next element is needed, the 2nd part is executed and it returns another stream `S2`. The next element is `S2.head`, which is `1`. As a result, we have `1 #:: 1 #:: S2.tail`. For the next element, `factorial.zipWithIndex.map`, which is `S2.tail`, asks `factorial` for the 2nd element, which is now the 2nd `1` and index `i` is now 1, so we get `2`.

**Given N pairs of parentheses, how many possible combinations of well-formed parentheses?**

The answer is [Catalan Number](catalan). Let me explain why.

The formula for Catalan Number for `n` pairs of parentheses is `C(2n, n) - C(2n, n + 1)`.
Since `C(2n, n)` is the total number of ways we can place `n` pairs (valid and invalid). We just need to prove that `C(2n, n + 1)` is the number of invalid ways to place `n` pairs. An invalid placement has a `)` at index `i` and the placement before `i` is valid. Or in other word, `i` is the first index where we have more `)` than `(`.
For example:
```scala
"())(" // i = 2
```

If we replace all `(` by `)` and vice versa from `0` to `i`, in total we will have `n + 1` `(` and `n - 1` `)`. This is true for any `i`. Hence, the number of ways to place `n + 1` `(` is the number of invalid combinations. This is exactly `C(2n, n + 1)`.

[cons_wrapper]: https://www.scala-lang.org/api/2.12.8/scala/collection/immutable/Stream$$ConsWrapper.html
[stream_to_cons_wrapper]: https://www.scala-lang.org/api/2.12.8/scala/collection/immutable/Stream$.html#consWrapper[A](stream:=%3Escala.collection.immutable.Stream[A]):scala.collection.immutable.Stream.ConsWrapper[A]
[catalan]: https://en.wikipedia.org/wiki/Catalan_number
