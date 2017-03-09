package services

import javax.inject.Inject
import models.{User, Person}
import play.api.cache.CacheApi
import scala.collection.mutable.ListBuffer

/**
  * Created by Charmy Garg on 08-Mar-17.
  */

trait ManagementServiceTrait {

  def getList: String

  def enableUser(username: String): Person

  def disableUser(username: String): Person
}

class ManagementService @Inject()(cache: CacheApi) extends ManagementServiceTrait {

  val person = Person("Charmy", "", "Garg", "charmygarg", "1234" , User("9897513530", "female", 22, List("Singing","Programming"), true ))

  cache.set(person.username, person)
  val list = cache.get[Person](person.username).get

  def getList: String = {
    val userList = list.username
    userList
  }

  def enableUser(username: String): Person = {
    val person: Person = cache.get[Person](username).get
    val updatedUser = person.user.copy(isEnable = true)
    val update = person.copy(user = updatedUser)
    update
  }

  def disableUser(username: String): Person = {
    val person: Person = cache.get[Person](username).get
    val updatedUser = person.user.copy(isEnable = false)
    val update = person.copy(user = updatedUser)
    update
  }

}
