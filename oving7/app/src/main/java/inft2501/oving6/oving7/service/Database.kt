package inft2501.oving6.oving7.service

import android.content.Context
import inft2501.oving6.oving7.managers.DatabaseManager
import org.json.JSONArray

class Database(context: Context) : DatabaseManager(context) {

	public fun insertFromJson(movies: JSONArray?){
		if (movies != null) {
			for (i in 0 until movies.length()) {
				val userDetail = movies.getJSONObject(i)
				this.insert(
					userDetail.getString("title"),
					userDetail.getString("director"),
					userDetail.getString("actor").split(",").toTypedArray().get(0),
					userDetail.getString("actor").split(",").toTypedArray().get(1).trimStart()
				)
			}
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
