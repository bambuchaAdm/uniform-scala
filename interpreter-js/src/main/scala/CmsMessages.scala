package ltbs.uniform.prototype

import ltbs.uniform.web.Messages

case class CmsMessages(
  underlying: Map[String, List[String]]
) extends Messages {

  @annotation.tailrec
  private def replaceArgs(
    input: String,
    args: List[String],
    count: Int = 0
  ): String = args match {
    case Nil    => input
    case h :: t => replaceArgs(input.replace(s"[{]$count[}]", h), t, count+1)
  }

  def apply(key: List[String], args: Any*): String = {

    @annotation.tailrec
    def inner(innerkey: List[String]): String = {
      innerkey match {
        case Nil => key.lastOption.getOrElse("???")
        case x::xs =>
          get(x, args:_*) match {
            case Some(o) => o
            case None => inner(xs)
          }
      }
    }
    inner(key)
  }

  def apply(key: String, args: Any*): String =
    get(key, args:_*).getOrElse(key)
 
  def get(key: String, args: Any*): Option[String] =
    underlying.get(key).flatMap{_.headOption}.map{
      replaceArgs(_,args.toList.map(_.toString))
    }

  def list(key: String, args: Any*): List[String] =
    underlying.getOrElse(key,Nil).map{ x =>
      replaceArgs(x,args.toList.map(_.toString))
    }
}

object CmsMessages {
  def fromText(input: String): CmsMessages = {
    val rawLines = input
      .replace("\\\n"," ")
      .split("\n")      
      .map{_.replace("#.*","").split("=",2).toList}
      .collect {
        case (k::v::Nil) => (k, v.replace("''","'"))
      }

    val groupedAndSorted =
      rawLines.toList
        .groupBy(_._1.replaceAll("[.][0-9]*$",""))
        .mapValues{_.sortBy(_._1).map{_._2}}

    CmsMessages(groupedAndSorted)
  }

}
