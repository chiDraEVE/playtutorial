import org.specs2.mutable._
import models.Task

import scala.collection.immutable.List

class TaskSpec extends Specification {
  "A ToDo-List " should {
    "show empty List of tasks when created" in {
      Task.all must beEqualTo(List())
    }
    "add tasks" in {
      Task.add("Task1")
      Task.add("Task2")
      Task.all must beEqualTo(List[Task](Task(1, "Task1"),Task(2,"Task2")))
    }
    "delete task" in {
      Task.add("Task1")
      Task.add("Task2")
      Task.delete(1)
      Task.all must beEqualTo(List[Task](Task(2,"Task2")))
    }
  }
}