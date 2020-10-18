package sontung.dangvu.stnote.db.note

import androidx.lifecycle.LiveData
import androidx.room.*
import sontung.dangvu.stnote.base.BaseDao

@Dao
abstract class NoteDao : BaseDao<Note>() {


    @Query ("SELECT * FROM note_table")
    abstract fun getAllNotes() : LiveData<List<Note>>

    @Query("DELETE FROM note_table")
    abstract suspend fun deleteNotes()
}