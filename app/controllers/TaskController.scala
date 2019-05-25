package controllers

import javax.inject.{Inject, Singleton}
import models.Task
import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton()
class TaskController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def tasks = Action {
    Ok(views.html.todolist(Task.all))
  }

  def newTask = Action(parse.urlFormEncoded) {
    implicit request =>
      Task.add(request.body.get("taskName").get.head)
      Redirect(routes.TaskController.tasks)
  }

  def deleteTask(id: Int) = Action {
    Task.delete(id)
    Ok
  }


}
