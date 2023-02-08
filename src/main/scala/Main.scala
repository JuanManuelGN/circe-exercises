import io.circe.*
import io.circe.generic.auto.*
import io.circe.parser.*

object Main extends App {

  println("hello")

  final case class Person(name: String, age: Int)

  val person: Person = Person("Alice", 27)

  val personEndodedAsJsonConvertedToString: String =
    Encoder[Person].apply(person).toString

  println(
    personEndodedAsJsonConvertedToString
  )

  // -------------------------------------------------
  val someString: String =
    """
      |{
      |  "name" : "Alice",
      |  "age" : 27
      |}
      |""".stripMargin
  val someStringWrong: String =
    """
        |{
        |  "name" : "Alice"
        |  "age" : 27
        |}
        |""".stripMargin

  val fromStringDecodedPerson: Either[Error, Person] =
    decode[Person](someString)

  println(fromStringDecodedPerson)

  val fromStringDecodedPersonError: Either[Error, Person] =
    decode[Person](someStringWrong)

  println(fromStringDecodedPersonError)
// -------------------------------------------------
  final case class PersonOption(name: Option[String], age: Int)

  val personOption: PersonOption = PersonOption(None, 27)

  val personOptionEndodedAsJsonConvertedToString: String =
    Encoder[PersonOption].apply(personOption).toString

  println(personOptionEndodedAsJsonConvertedToString)

//  val fromStringDecodedPersonOption: Either[Error, PersonOption] =
//    decode[Person](someString)
//
//  println(fromStringDecodedPerson)
}
