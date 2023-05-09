package refined_types

import io.github.iltotore.iron.*
import io.github.iltotore.iron.constraint.numeric.*

object refinedtypes:

  type Between[Min, Max] = GreaterEqual[Min] & LessEqual[Max]
  private type LIMIT = 1000
  type CandidateSetSize = Int :| Between[0, LIMIT]

  case class Config(size: CandidateSetSize)

  val validConfig: Config = Config(10)
  /**
   * The following declaration produces a compilation error
   * [error] 15 |  val invalidConfig: Config = Config(2500)
   * [error]    |                                     ^^^^
   * [error]    |-- Constraint Error --------------------------------------------------------
   * [error]    |Could not satisfy a constraint for type scala.Int.
   * [error]    |
   * [error]    |Value: 2500
   * [error]    |Message: Should be greater than or equal to 0 & Should be less than or equal to 1000
   * [error]    |----------------------------------------------------------------------------
   * [error]    |----------------------------------------------------------------------------
   * [error]    |Inline stack trace
   * [error]    |- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
   * [error]    |This location contains code that was inlined from refinedtypes.scala:15
   * [error]     ----------------------------------------------------------------------------
   * [error] one error found
   *
   */
//  val invalidConfig: Config = Config(2500)

