package services

import javax.inject.Inject
import models.{User, Person}
import play.api.cache.CacheApi
import scala.collection.mutable.ListBuffer

/**
  * Created by Charmy Garg on 08-Mar-17.
  */

trait ManagementServiceTrait {

  def getUser: String

  def enableUser(username: String): Boolean

  def disableUser(username: String): Boolean
}

class ManagementService @Inject()(cache: CacheApi) extends ManagementServiceTrait {

  val person = Person("Charmy", "Dinesh", "Garg", "charmygarg", "1234", User("9897513530", "female", 22, List("Singing", "Programming"), true))

  cache.set(person.username, person)
  val data = cache.get[Person](person.username).get

  def getUser: String = {
    val user = data.username
    user
  }

  def enableUser(username: String): Boolean = {
    val updatedUser = data.user.copy(isEnable = true)
    val update = person.copy(user = updatedUser)
    cache.remove(username)
    cache.set(username, update)
    true
  }

  def disableUser(username: String): Boolean = {
    val updatedUser = data.user.copy(isEnable = false)
    val update = person.copy(user = updatedUser)
    cache.remove(username)
    cache.set(username, update)
    false
  }

}
