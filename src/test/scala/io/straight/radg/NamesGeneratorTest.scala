package io.straight.radg

import io.straight.radg.randomtypes._
import org.scalatest.{FlatSpec, Matchers}

class NamesGeneratorTest extends FlatSpec with Matchers {

  val femaleTitles = RadgContext.Settings.getList("radg.lists.person.title.values.F")
  val maleTitles = RadgContext.Settings.getList("radg.lists.person.title.values.M")

  val regexp = """^(.*)\s+(.*)\s+(.*)$""".r

  "Generating a full name" should "match a regular expression" in {
    val ramondom = SeqOfSeqOfStringsGenerator(9000,List(
      FullNameGenerator("full_name")
    ))

    val result = ramondom.generate()
    for (row <- result._2) {
      println(row)
      regexp.findFirstIn(row(0)).isDefined should be (true)
    }
  }
}

