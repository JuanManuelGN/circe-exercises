import io.circe.Encoder
import io.circe.generic.auto.*

object AutoDerivation extends App:

  /** Encode result:
   * {
   * "name" : "Alice",
   * "age" : 27
   * }
   */
  final case class Person(
      name: String,
      age: Int
  )

  val person: Person = Person("Alice", 27)

  def personEncodedAsJsonConvertedToString: String =
    Encoder[Person].apply(person).toString

  println(
    personEncodedAsJsonConvertedToString
  )
