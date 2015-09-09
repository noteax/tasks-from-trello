package org.abariev.tasks.akvelon.v12

import org.abariev.tasks.akvelon.annotations.Task

@Task(set = "v12", description = "Abs(int)")
object AbsoluteInt {

  def run {
    println("Executing on values:")
    printAbsoluteValue(0)
    printAbsoluteValue(1)
    printAbsoluteValue(-2)
    printAbsoluteValue(5191)
    printAbsoluteValue(8)
    printAbsoluteValue(-16)
    printAbsoluteValue(0xFFFFFFFF)
    printAbsoluteValue(-0xFFFFFFFF)
    printAbsoluteValue(Int.MaxValue)
    printAbsoluteValue(Int.MinValue) // abs value bigger than int can hold
  }

  def printAbsoluteValue(value: Int) {
    printf("\t%1$11d => %2$11d ((1 | (%1$11d >> 31)) * %1$11d%n", value, absoluteValue(value))
  }

  def absoluteValue(value: Int): Int = (1 | (value >> 31)) * value
}
