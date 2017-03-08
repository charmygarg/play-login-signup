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
   true ))

  def getList: List[String] = {
    val userList = list.map(_.username).toList
    userList
  }

  def enableUser(username: String): CacheApi = {
    cache.set("isEnable",true)
    println(cache.get("isEnable"))
    cache
  }

  def disableUser(username: String): CacheApi = {
    cache.set("isEnable",false)
    println(cache.get("isEnable"))
    cache
  }

}
