package inft2501.oving3

import java.io.Serializable
import java.time.LocalDate

data class Person(var name:String, var birthday: LocalDate) : Serializable
