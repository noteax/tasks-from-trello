package org.abariev.tasks.akvelon.v12

import scala.runtime.ScalaRunTime._

import org.abariev.tasks.akvelon.annotations.Task

@Task(set = "v12", description = "HeightOfTree")
object HeightOfTree {

  def run {
    printAssertion(Array(3, 3, 3, -1, 2, 0, 1, 2, 3, 4), 4);
    printAssertion(Array(3, 3, 3, -1, 2, 0, 1, 2, 3, 4, 5, 10), 5);
    printAssertion(Array(-1, 0, 1, 2, 3, 4, 5), 7);
    printAssertion(Array(6, 2, 3, 5, 5, -1, 4, 2), 4);
    printAssertion(Array(), 0);
  }

  def printAssertion(tree: Array[Int], height: Int) {
    val treeHeight = getHeight(tree)
    printf("\t(%b)\tActual: (%d) Calculated: (%d) For: %s%n", height == treeHeight, height, treeHeight, stringOf(tree))
  }

  class CalculationContext(var treeHeight: Int, val tree: Array[Int], val nodesHeight: Array[Int])

  def getHeight(tree: Array[Int]): Int = {
    val calculationContext = new CalculationContext(0, tree, new Array(tree.length))
    for (nodeIndex <- 0 to (tree.length - 1)) {
      val nodeHeight = getNodeHeight(calculationContext, nodeIndex)
      calculationContext.treeHeight = Math.max(nodeHeight, calculationContext.treeHeight)
    }
    calculationContext.treeHeight
  }

  def getNodeHeight(calculationContext: CalculationContext, nodeIndex: Int): Int = {
    if (0 == calculationContext.nodesHeight(nodeIndex)) {
      // fill heights array
      val parentNodeIndex = calculationContext.tree(nodeIndex)
      calculationContext.nodesHeight(nodeIndex) = if (-1 != parentNodeIndex)
        getNodeHeight(calculationContext, parentNodeIndex) + 1 else 1;
    }
    calculationContext.nodesHeight(nodeIndex)
  }

}
