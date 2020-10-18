package sontung.dangvu.stnote.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import sontung.dangvu.stnote.db.note.Note
import sontung.dangvu.stnote.db.note.NoteDao
import sontung.dangvu.stnote.db.todo.ToDoDao
import sontung.dangvu.stnote.db.todo.ToDoTask

@Database (entities = [Note::class, ToDoTask::class], exportSchema = false, version = 1)
@TypeConverters()
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDao
    abstract fun toDoDao() : ToDoDao
}