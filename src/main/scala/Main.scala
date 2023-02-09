//import io.circe.*
//import io.circe.generic.auto.*
//import io.circe.parser.*
//
//object Main extends App {
//
//  final case class Person(name: String, age: Int)
//
//  val person: Person = Person("Alice", 27)
//
//  val personEncodedAsJsonConvertedToString: String =
//    Encoder[Person].apply(person).toString
//
//  println(
//    s"\npersonEncodedAsJsonConvertedToString\n$personEncodedAsJsonConvertedToString"
//  )
//
//  // -------------------------------------------------
//  val someString: String =
//    """
//      |{
//      |  "name" : "Alice",
//      |  "age" : 27
//      |}
//      |""".stripMargin
//
//  val fromStringDecodedPerson: Either[Error, Person] =
//    decode[Person](someString)
//
//  println(
//    s"\nfromStringDecodedPerson\n$fromStringDecodedPerson"
//  )
//  // -------------------------------------------------
//  val someStringWrong: String =
//    """
//      |{
//      |  "name" : "Alice"
//      |  "age" : 27
//      |}
//      |""".stripMargin
//  val fromStringDecodedPersonError: Either[Error, Person] =
//    decode[Person](someStringWrong)
//
//  println(
//    s"\nfromStringDecodedPersonError\n$fromStringDecodedPersonError"
//  )
//// -------------------------------------------------
//  final case class PersonOption(name: Option[String], age: Int)
//
//  val personOption: PersonOption = PersonOption(None, 27)
//
//  val personOptionEndodedAsJsonConvertedToString: String =
//    Encoder[PersonOption].apply(personOption).toString
//
//  println(
//    s"\npersonOptionEndodedAsJsonConvertedToString\n$personOptionEndodedAsJsonConvertedToString"
//  )
//  // -------------------------------------------------
//  val someStringNameNull: String =
//    """
//      |{
//      |  "name" : null,
//      |  "age" : 27
//      |}
//      |""".stripMargin
//
//  val fromStringDecodedPersonOption: Either[Error, PersonOption] =
//    decode[PersonOption](someStringNameNull)
//
//  println(
//    s"\nfromStringDecodedPersonOption\n$fromStringDecodedPersonOption"
//  )
//  // -------------------------------------------------
//
//  val fromStringDecodedPersonUsingParse =
//    parse(someString).flatMap(Decoder[Person].decodeJson)
//
//  println(
//    s"\nfromStringDecodedPersonUsingParse\n$fromStringDecodedPersonUsingParse"
//  )
//
//  import scala.util.chaining.*
//  val fromStringDecodedPersonUsingChain =
//    someString
//      .pipe(parse)
//      .flatMap(_.as[Person])
//
//  println(
//    s"\nfromStringDecodedPersonUsingChain\n$fromStringDecodedPersonUsingChain"
//  )
//
//  val fromStringDecodedPersonOtherWaySameResult =
//    someString
//      .pipe(parse)
//      .map(HCursor.fromJson)
//      .flatMap(Decoder[Person].apply)
//
//  println(
//    s"\nfromStringDecodedPersonOtherWaySameResult\n$fromStringDecodedPersonOtherWaySameResult"
//  )
//
//  val fromStringDecodedPersonOtherSimpleUsingPipeSameResult =
//    someString
//      .pipe(decode[Person])
//
//  println(
//    s"\nfromStringDecodedPersonOtherSimpleUsingPipeSameResult\n$fromStringDecodedPersonOtherSimpleUsingPipeSameResult"
//  )
//
//  import io.circe.syntax.*
//
//  val personEncodedAsJsonConvertedToStringUsingCirceSyntax: String =
//    person.asJson.spaces2
//
//  println(
//    s"\npersonEncodedAsJsonConvertedToStringUsingCirceSyntax\n$personEncodedAsJsonConvertedToStringUsingCirceSyntax"
//  )
//
//}
