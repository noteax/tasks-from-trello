package org.abariev.tasks.akvelon.v12

import org.abariev.tasks.akvelon.annotations.Task

@Task(set = "v12", description = "No Branching please (0x0 or OxFFFFFFFF)")
object NoBranchingPlease {

  def run {
    println("Executing on values:")
    printZffTransform(0)
    printZffTransform(1)
    printZffTransform(-2)
    printZffTransform(5191)
    printZffTransform(8)
    printZffTransform(-16)
    printZffTransform(0xFFFFFFFF)
    printZffTransform(-0xFFFFFFFF)
    printZffTransform(Int.MaxValue)
    printZffTransform(Int.MinValue)
  }

  def printZffTransform(value: Int) {
    printf("\t%1$11d => %2$8h ((%1$11d | -%1$11d) >>> 31) * 0xFFFFFFFF%n", value, zffTransform(value))
  }

  /**
   * OxFFFFFFFF could be replaced with any number
   * Shorter: -value|value>>31
   */
  def zffTransform(value: Int): Int = ((-value | value) >>> 31) * 0xFFFFFFFF

}
