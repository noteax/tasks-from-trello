package org.abariev.tasks.akvelon.runner

import java.lang.Class
import java.net.URL
import org.abariev.tasks.akvelon.annotations.Task
import scala.collection.JavaConversions._
import org.abariev.tasks.akvelon.NoBranchingPlease

object TasksRunner extends App {

  runWithTasks()

  def runWithTasks(tasks: List[Class[_]]) {
    println("Available tasks: ");
    tasks.foreach { x => println() }
    println("Select task ")
  }

  def blabla {
    val tasks = getTasks(getRootClasses("org.abariev.tasks.akvelon"))
    println("Select task:")
    println(tasks)
  }

  def getTasks(classes: List[Object]): Map[Class[Object], Task] = {
    null
  }

  def getRootClasses(packageName: String): List[URL] = {
    val classLoader = getClass.getClassLoader
    println(classLoader.getResource(".").getFile + " " + classLoader.getClass)

    val resources = classLoader.getResources("NoBranchingPlease$.class") //packageName.replaceAll(".", "/")+"/");
    println("Size: " + resources.toList.size)
    resources.filter { x => x.getFile.endsWith(".class") }.toList
  }

}