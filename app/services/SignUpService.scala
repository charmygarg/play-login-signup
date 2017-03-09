package services

import javax.inject.Inject
import models.Person
import play.api.cache.CacheApi

trait SignUpServiceTrait {
  def setCache(value: Person): Boolean
}

class SignUpService @Inject()(cache: CacheApi) extends SignUpServiceTrait{

  def setCache(value: Person) = {
    cache.set(value.username, value)
    //cache.remove(value.username)
    true
  }

}
