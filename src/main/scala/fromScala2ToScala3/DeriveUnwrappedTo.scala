package fromScala2ToScala3

import io.circe.generic.semiauto.*
import io.circe.{Decoder, Encoder}
import io.circe.syntax.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/* Decode result:
[
  "2023-02-09",
  "2023-02-09",
  "2023-02-09"
]
 */
final case class EventsEx1(events: List[LocalDate]) extends AnyVal
object EventsEx1 {
  given Decoder[EventsEx1] = Decoder.decodeList[LocalDate].map(EventsEx1.apply)
  given Encoder[EventsEx1] = Encoder.encodeList[LocalDate].contramap(_.events)
}
object ExecEx1 extends App {
  
  import EventsEx1.*
  
  val e = EventsEx1(
    List(
      LocalDate.now(),
      LocalDate.now(),
      LocalDate.now()
    )
  )

  println(s"Before Decode:\n$e")
  println(s"After Decode:\n${e.asJson}")
}

/* Decode result:
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
  given Decoder[EventsEx2] = Decoder.forProduct1("events")(EventsEx2.apply)
  given Encoder[EventsEx2] = Encoder.forProduct1("events")(_.events)
}
object ExecEx2 extends App {
  
  import EventsEx2.*
  
  val e = EventsEx2(
    List(
      LocalDate.now(),
      LocalDate.now(),
      LocalDate.now()
    )
  )

  println(s"Before Decode:\n$e")
  println(s"After Decode:\n${e.asJson}")
}

/* Decode result:
{
  "events" : [
    "2023-02-09",
    "2023-02-09",
    "2023-02-09"
  ]
}
 */
final case class EventsEx5(events: List[LocalDate])
object EventsEx5 {
  given Decoder[EventsEx5] = Decoder.forProduct1("events")(EventsEx5.apply)
  given Encoder[EventsEx5] = Encoder.forProduct1("events")(_.events)
}
object ExecEx5 extends App {

  import EventsEx5.*

  val e = EventsEx5(
    List(
      LocalDate.now(),
      LocalDate.now(),
      LocalDate.now()
    )
  )

  println(s"Before Decode:\n$e")
  println(s"After Decode:\n${e.asJson}")
}

/* Decode result:
[
  "2023-02-09",
  "2023-02-09",
  "2023-02-09"
]
 */
opaque type EventsEx3 = List[LocalDate]
object EventsEx3 {
  def apply(ls: List[LocalDate]): EventsEx3 = ls
  extension (events: EventsEx3) {
    def events: List[LocalDate] = events
    def format: List[String]    = events.map(_.format(fmtDate))
  }
  
  val fmtDate: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
  
  given Decoder[EventsEx3] = Decoder.decodeList[LocalDate]
  given Encoder[EventsEx3] = Encoder.encodeList[LocalDate]
}
object ExecEx3 extends App {
  
  import EventsEx3.*
  
  val e = EventsEx3(
    List(
      LocalDate.now(),
      LocalDate.now(),
      LocalDate.now()
    )
  )

  println(s"Before Decode:\n$e")
  println(s"After Decode:\n${e.asJson}")
}

/**
 * Se queda pillado en bucle infinito
 */
opaque type EventsEx4 = List[LocalDate]
object EventsEx4 {
  def apply(ls: List[LocalDate]): EventsEx4 = ls
  extension (events: EventsEx4) {
    def events: List[LocalDate] = events
    def format: List[String]    = events.map(_.format(fmtDate))
  }

  val fmtDate: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

  given Decoder[EventsEx4] = Decoder.forProduct1("events")(EventsEx4.apply)
  given Encoder[EventsEx4] = Encoder.forProduct1("events")(_.events)
}
object ExecEx4 extends App {
  
  import EventsEx4.*

  val e = EventsEx4(
    List(
      LocalDate.now(),
      LocalDate.now(),
      LocalDate.now()
    )
  )

  println(e.asJson)
}
