package models

case class User( phone: String, gender: String, age: Int, hobby: List[String], status: String, isEnable: Boolean = true)
