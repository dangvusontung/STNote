package sontung.dangvu.stnote.ui.note

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_note.*
import kotlinx.android.synthetic.main.note_item.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sontung.dangvu.stnote.R
import sontung.dangvu.stnote.db.note.Note
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 * Use the [NoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

private const val TAG = "NoteFragment"

@AndroidEntryPoint
class NoteFragment : Fragment() {

    private val noteViewModel: NoteViewModel by activityViewModels()

    private val noteAdapter by lazy {
        NoteAdapter { note, view ->
            Timber.d("$note")
            when (view.id) {
                R.id.note_item -> openNote(note)
                else -> deleteNote(note)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        noteViewModel.getAllNotes().observe(this.viewLifecycleOwner) {
            noteAdapter.submitList(it)
        }

        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        note_list.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    (layoutManager as GridLayoutManager).layoutDirection
                )
            )
            adapter = noteAdapter

        }

        add_mock_note.setOnClickListener {
            addMockNote()
        }

        delete_all.setOnClickListener {
            deleteAllMockNote()
        }

        add_new_note.setOnClickListener {
            createNewNote()
        }
    }

    private fun openNote(note: Note) {
        moveToEditFragment(note)
    }

    private fun addMockNote() {
        for (i in 1..10) {
            GlobalScope.launch {
                val note = Note("note #$i", "note content #$i")
                noteViewModel.insertNote(note)
            }
        }
    }

    private fun deleteAllMockNote() {
        GlobalScope.launch {
            noteViewModel.deleteAll()
        }
    }

    private fun deleteNote(note: Note) {
        GlobalScope.launch {
            noteViewModel.deleteNote(note)
        }
    }

    private fun createNewNote() {
        moveToEditFragment(Note("", ""), true)
    }

    private fun moveToEditFragment(note: Note, isNewNote : Boolean = false) {
        val action = NoteFragmentDirections.actionNoteFragmentToEditNoteFragment(note, isNewNote)
        findNavController().navigate(action)
    }
}