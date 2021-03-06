package ltbs.uniform.gformsparser

import enumeratum._

sealed trait DevelopmentPhase extends EnumEntry with EnumEntry.Lowercase
object DevelopmentPhase extends Enum[DevelopmentPhase] {

  lazy val values = findValues

  case object Research extends DevelopmentPhase
  case object Alpha extends DevelopmentPhase
  case object Beta extends DevelopmentPhase
  case object Live extends DevelopmentPhase
}
