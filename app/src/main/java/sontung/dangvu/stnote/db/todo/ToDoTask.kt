package sontung.dangvu.stnote.db.todo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity
class ToDoTask(
    val description: String,
//    var dueDate: Date,
//    var hasDone: Boolean = false
) : Serializable {

    @PrimaryKey
    var timeCreated = System.currentTimeMillis()
}