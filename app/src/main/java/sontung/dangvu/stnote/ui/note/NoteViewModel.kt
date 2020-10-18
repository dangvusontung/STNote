package sontung.dangvu.stnote.ui.note

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import sontung.dangvu.stnote.db.note.Note

class NoteViewModel @ViewModelInject constructor(
    private val noteRepository: NoteRepository,
) : ViewModel() {

    fun getAllNotes() = noteRepository.getAllNotes()

    suspend fun insertNote(note : Note) = noteRepository.insert(note)

    suspend fun deleteNote(note: Note) = noteRepository.delete(note)

    suspend fun updateNote(note: Note) = noteRepository.update(note)

    suspend fun deleteAll() = noteRepository.deleteAll()
}