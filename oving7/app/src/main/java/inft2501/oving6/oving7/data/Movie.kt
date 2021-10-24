package inft2501.oving6.oving7.data

data class Movie(val title:String, val director:String, val actors: Array<String>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Movie

        if (title != other.title) return false
        if (director != other.director) return false
        if (!actors.contentEquals(other.actors)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + director.hashCode()
        result = 31 * result + actors.contentHashCode()
        return result
    }
}
