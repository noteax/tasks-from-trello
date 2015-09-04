package org.abariev.tasks.akvelon

import org.abariev.tasks.akvelon.annotations.Task

object TasksRunner {

  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)

  def main(args : Array[String]) {
    Map[Class, Task] tasks = getTasks(getRootClasses("org.abariev.tasks.akvelon"))
    
    tasks.
    
    println( "Select task:" )
    
  }    
    
  def Map[Class, Task] getTasks(classes: List[Class]) {
    
  }
  
  def List[Class] getRootClasses(String package) {
    Classloader classloader = Thread.currentThread().getContextClassLoader()    
  }
  
}