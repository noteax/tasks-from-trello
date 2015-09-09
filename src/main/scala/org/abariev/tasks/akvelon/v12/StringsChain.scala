package org.abariev.tasks.akvelon.v12

import collection.mutable.Map
import scala.runtime.ScalaRunTime._

import org.abariev.tasks.akvelon.annotations.Task

@Task(set = "v12", description = "Strings chain")
object StringsChain {

  def run {
    printIsChain(List("ab", "bc", "cd")) //ab|bc|cd 
    printIsChain(List("as", "sc", "sn", "nc", "cw", "cs")) // as|sn|nc|cs|sc|cw
    printIsChain(List("sb", "sb", "bh", "hs", "bs")) // sb|bh|hs|sb|bs
    printIsChain(List("as", "sg", "gs", "sw", "sq")) // false
  }

  def printIsChain(elements: List[String]) {
    printf("\t[%b]\tfor %s%n", isChain(elements), stringOf(elements))
  }

  def isChain(elements: List[String]): Boolean = {
    val counts = Map[String, Int]().withDefaultValue(0)
    elements.foreach { adjustCounts(_, counts) }
    counts.size <= 2
  }

  def adjustCounts(element: String, counts: Map[String, Int]) {
    executeWithChecks(element.take(1), counts, _ + _)
    executeWithChecks(element.takeRight(1), counts, _ - _)
  }

  /**
   * Executes operation on value for passed key, removes entry if resulting value is zero
   */
  def executeWithChecks[T](key: T, valuesMap: Map[T, Int], operation: (Int, Int) => Int) {
    val newValue = operation(valuesMap(key), 1);
    if (0 == newValue) {
      valuesMap.remove(key)
    } else {
      valuesMap.put(key, newValue)
    }
  }

}
