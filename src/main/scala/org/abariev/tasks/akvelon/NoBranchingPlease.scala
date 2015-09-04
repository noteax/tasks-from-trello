package org.abariev.tasks.akvelon

import org.abariev.tasks.akvelon.annotations.Task

@Task(description="Return 0x0 or OxFFFFFFFF w/o branching")
object NoBranchingPlease {

  def run {
    println("No branching please");
  }
}
