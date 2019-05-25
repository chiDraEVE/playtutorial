package models

case class Task(id: Int, name: String)

object Task {

  private var taskList: List[Task] = List()

  def all: List[Task] = {
    taskList
  }

  def add(taskName: String) = {

    if (taskList.isEmpty)
      taskList = taskList ++ List(Task(1, taskName))
    else
      taskList = taskList ++ List(Task(taskList.last.id + 1, taskName))

  }

  def delete(taskId: Int) = {

    taskList = taskList.filterNot(task => task.id == taskId)

  }

}
