package services

import javax.inject.Inject
import models.{User, Person}
import play.api.cache.CacheApi
import scala.collection.mutable.ListBuffer

/**
  * Created by Charmy Garg on 08-Mar-17.
  */

trait ManagementServiceTrait {

  def getList: List[String]
}

class ManagementService @Inject() (cache: CacheApi) extends ManagementServiceTrait {

  val list = new ListBuffer[Person]() += Person("Charmy", "", "Garg", "charmygarg", "1234" , User("9897513530", "female", 22, List("Singing","Programming"),
  "normal", true ))

  val getData = cache.get[ListBuffer[Person]]("Key").get

  def getList: List[String] = {
    val userList = getData.map(_.username).toList
    userList
  }

  def enableUser(username: String): Boolean = {
    val enableList = getData.map {
      case head if head.username == username => head.copy(isEnable = true)
    }
    cache.set("key", enableList)
    true
  }

  def disableUser(username: String): Boolean = {
    val enableList = getData.map {
      case head if head.username == username => head.copy(isEnable = false)
    }
    cache.set("key", enableList)
    true
  }

}
