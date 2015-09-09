package org.abariev.tasks.akvelon.runner

import java.lang.Class
import java.net.URL

import scala.collection.immutable.SortedMap
import scala.collection.immutable.Iterable
import scala.collection.JavaConversions._
import scala.reflect.runtime._
import scala.reflect.runtime.universe._

import org.abariev.tasks.akvelon.annotations.Task

import org.abariev.tasks.akvelon.v12._

object TasksRunner extends App {

  runWithTasks(List(AbsoluteInt, HeightOfTree, MaxHeap, NoBranchingPlease, StringsChain))

  def runWithTasks(taskClasses: List[_]) {

    val sets = SortedMap(taskClasses.groupBy { x => getTask(x).set() }.toSeq: _*)
    println("Available task sets:")
    for (set <- sets zipWithIndex) printf("\t%d. %s%n", set._2 + 1, set._1._1)

    val tasks = sets.values.toIndexedSeq(readIndexFor(sets))
    println("\tAvailable tasks:")
    for (task <- tasks zipWithIndex) printf("\t%d. %s%n", task._2 + 1, getTask(task._1).description())
    val task = tasks.get(readIndexFor(tasks))

    printf("Running %s ...%n", task.getClass.getSimpleName)
    task.getClass().getMethod("run").invoke(task)
  }

  def readIndexFor[T](iterable: Iterable[T]): Integer = {
    println("Select index: ")
    val index = readInt() - 1
    println
    if (0 > index || index >= iterable.size) {
      sys.error("Selected wrong set")
    }
    index
  }

  def getTask[T](taskObject: T): Task = taskObject.getClass.getAnnotation(classOf[Task])
  def setSplitter(taskDef: Task): String = taskDef.description()
  def descSplitter(taskDef: Task): String = taskDef.description()

}