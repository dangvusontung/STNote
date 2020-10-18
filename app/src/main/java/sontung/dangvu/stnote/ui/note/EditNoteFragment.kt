package sontung.dangvu.stnote.ui.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_edit_note.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sontung.dangvu.stnote.R
import sontung.dangvu.stnote.db.note.Note
import kotlin.properties.Delegates


class EditNoteFragment : Fragment() {

    private val noteViewModel : NoteViewModel by activityViewModels()

    private val args : EditNoteFragmentArgs by navArgs()

    private lateinit var editingNote : Note

    private var isNewNote by Delegates.notNull<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        args.note?.let {
            editingNote = it
        }

        isNewNote = args.isNewNote

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editingNote.let {
            note_title.setText(it.title)
            note_content.setText(it.content)
        }

        requireActivity().onBackPressedDispatcher.addCallback(backPressedCallback)
    }

    private fun saveNewNote() {
        if (note_title.text.toString().isNotEmpty() && note_content.text.toString().isNotEmpty()) {
            val note = Note(note_title.text.toString(), note_content.text.toString())
            GlobalScope.launch {
                noteViewModel.insertNote(note)
            }
        }
    }

    private fun saveNote() {
        editingNote.let {
            it.title = note_title.text.toString()
            it.content = note_content.text.toString()

            GlobalScope.launch {
                noteViewModel.updateNote(it)
            }
        }
    }

    private val backPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (isNewNote) {
                saveNewNote()
            } else {
                saveNote()
            }
            findNavController().popBackStack()
        }
    }

}