package ltbs.uniform.sampleprograms

import org.atnos.eff._
import ltbs.uniform._
import cats.implicits._

object GreasySpoon {

  // type Money = Int
  // type GreasyStack = Fx2[UniformAsk[Int,?], UniformAsk[Boolean,?]]

  // def greasySpoon[S : _uniform[Int,?] : _uniform[Boolean,?]] : Eff[S,Money] = for {
  //   age           <- ask[S,Int]("age")
  //   food          <- ask[S,Boolean]("wantFood")
  //   tea           <- ask[S,Boolean]("wantTea")
  //   baconCost     <- ask[S,Int]("bacon").map(_ * 12) emptyUnless food
  //   eggsCost      <- ask[S,Int]("eggs").map(_ * 24) emptyUnless food
  //   foodCost      = baconCost + eggsCost
  //   teaCost       <- ask[S,Int]("sugar").map(_ * 10 + 50) emptyUnless tea
  //   youngDiscount = if (age < 16) teaCost / 10 else 0
  //   oldDiscount   = if (age > 60) (teaCost + foodCost) * (Math.min(age - 60,25) / 100) else 0
  // } yield (foodCost + teaCost + youngDiscount + oldDiscount)

}
