package services

import javax.inject.Inject
import models.Person
import play.api.cache.CacheApi

trait SignUpServiceTrait {
  def setCache(value: Person): Boolean
}

class SignUpService @Inject()(cache: CacheApi) extends SignUpServiceTrait{

  def setCache(value: Person): Boolean = {
    cache.set(value.username, value)
    true
  }

}
