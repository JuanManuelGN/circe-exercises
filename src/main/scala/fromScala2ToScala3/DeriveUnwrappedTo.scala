package fromScala2ToScala3


import io.circe.{Decoder, Encoder}
import io.circe.syntax._

import java.time.LocalDate
import io.circe.generic.extras.semiauto.{deriveUnwrappedDecoder, deriveUnwrappedEncoder}

/*
[
  "2023-02-09",
  "2023-02-09",
  "2023-02-09"
]
 */
final case class EventsEx1(events: List[LocalDate]) extends AnyVal
object EventsEx1 {
  implicit val dec: Decoder[EventsEx1] = Decoder.decodeList[LocalDate].map(EventsEx1.apply)
  implicit val enc: Encoder[EventsEx1] = Encoder.encodeList[LocalDate].contramap(_.events)
}
object ExecEx1 extends App {
  import EventsEx1._
  val e = EventsEx1(
    List(
      LocalDate.now(),
      LocalDate.now(),
      LocalDate.now()
    )
  )

  println(e.asJson)
}

/*
{
  "events" : [
    "2023-02-09",
    "2023-02-09",
    "2023-02-09"
  ]
}
 */
final case class EventsEx2(events: List[LocalDate]) extends AnyVal
object EventsEx2 {
  implicit val dec: Decoder[EventsEx2] = Decoder.forProduct1("events")(EventsEx2.apply)
  implicit val enc: Encoder[EventsEx2] = Encoder.forProduct1("events")(_.events)
}
object ExecEx2 extends App {
  import EventsEx2._
  val e = EventsEx2(
    List(
      LocalDate.now(),
      LocalDate.now(),
      LocalDate.now()
    )
  )

  println(
    e.asJson
  )
}

/*
[
  "2023-02-09",
  "2023-02-09",
  "2023-02-09"
]
 */
final case class EventsEx3(events: List[LocalDate]) extends AnyVal
object EventsEx3 {
  implicit val decEvents: Decoder[EventsEx3] = deriveUnwrappedDecoder
  implicit val encEvents: Encoder[EventsEx3] = deriveUnwrappedEncoder
}
object ExecEx3 extends App {
  import EventsEx3._
  val e = EventsEx3(
    List(
      LocalDate.now(),
      LocalDate.now(),
      LocalDate.now()
    )
  )

  println(e.asJson)
}

/*
{
  "events" : [
    "2023-02-09",
    "2023-02-09",
    "2023-02-09"
  ]
}
 */
final case class EventsEx4(events: List[LocalDate]) extends AnyVal
object EventsEx4 {
  import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

  implicit val decEvents: Decoder[EventsEx4] = deriveDecoder
  implicit val encEvents: Encoder[EventsEx4] = deriveEncoder
}
object ExecEx4 extends App {
  import EventsEx4._
  val e = EventsEx4(
    List(
      LocalDate.now(),
      LocalDate.now(),
      LocalDate.now()
    )
  )

  println(e.asJson)
}