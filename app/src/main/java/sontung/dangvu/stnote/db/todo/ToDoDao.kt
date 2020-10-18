package sontung.dangvu.stnote.db.todo

import androidx.room.Dao
import sontung.dangvu.stnote.base.BaseDao

@Dao
abstract class ToDoDao : BaseDao<ToDoTask>() {
}