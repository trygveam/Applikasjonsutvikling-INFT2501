package inft2501.oving6.oving7.service

import android.content.Context
import inft2501.oving6.oving7.managers.DatabaseManager
import inft2501.oving6.oving7.managers.FileManager

class Database(context: Context) : DatabaseManager(context) {

	init {
		try {
			this.clear()
			this.insert("Inception", "Christopher Nolan","Leanordo DiCaprio","second")
			this.insert("Tenet", "Christopher Nolan","Robert Pattinson","second3")
			this.insert("James Bond: No Time to Die","Cary Joji Fukunaga","Daniel Craig","Rami Malek")
		} catch (e: Exception) {
			e.printStackTrace()
		}
	}

	val allMovies: ArrayList<String>
		get() = performQuery(TABLE_MOVIE, arrayOf(ID,MOVIE_TITLE))

	val allActors: ArrayList<String>
		get() = performQuery(TABLE_ACTOR, arrayOf(ID, ACTOR_NAME), null)


	val allMoviesAndActors: ArrayList<String>
		get() {
			val select = arrayOf("$TABLE_ACTOR.$ACTOR_NAME", "$TABLE_MOVIE.$MOVIE_TITLE")
			val from = arrayOf(TABLE_MOVIE, TABLE_ACTOR, TABLE_MOVIE_ACTOR)
			val join = JOIN_MOVIE_ACTOR

			return performRawQuery(select, from, join)
		}

	val getMoviesByDirector: ArrayList<String>
		get() = performQuery(TABLE_MOVIE,arrayOf(MOVIE_TITLE) ,"DIRECTOR = 'Christopher Nolan'")

}
