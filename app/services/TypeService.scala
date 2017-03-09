package services

import javax.inject.Inject

import play.api.{Configuration, Environment}

/**
  * Created by Charmy Garg on 08-Mar-17.
  */

trait TypeServiceTrait {
  def getType: String
}

class TypeService @Inject()(environment: Environment, configuration: Configuration) extends TypeServiceTrait {
  def getType: String = {
    configuration.getString("user.type").fold("not found")(identity)
  }
}
