package sontung.dangvu.stnote.ui.note

import androidx.lifecycle.LiveData
import sontung.dangvu.stnote.db.note.Note
import sontung.dangvu.stnote.db.note.NoteDao
import javax.inject.Inject

class NoteRepositoryProvider @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {

    override suspend fun insert(note: Note) = noteDao.insert(note)

    override suspend fun update(note: Note) = noteDao.update(note)

    override suspend fun delete(note: Note) = noteDao.delete(note)

    override suspend fun deleteAll() = noteDao.deleteNotes()

    override fun getAllNotes(): LiveData<List<Note>> = noteDao.getAllNotes()


}

interface NoteRepository {
    suspend fun insert(note: Note)
    suspend fun update(note : Note)
    suspend fun delete(note: Note)
    suspend fun deleteAll()
    fun getAllNotes() : LiveData<List<Note>>
}