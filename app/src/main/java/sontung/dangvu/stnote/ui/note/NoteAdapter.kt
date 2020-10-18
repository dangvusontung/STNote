package sontung.dangvu.stnote.ui.note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sontung.dangvu.stnote.R
import sontung.dangvu.stnote.databinding.NoteItemBinding
import sontung.dangvu.stnote.db.note.Note
import sontung.dangvu.stnote.utils.noteCallBack
import timber.log.Timber

class NoteAdapter(
    private val onNoteClick : (Note, View) -> Unit
) : ListAdapter<Note, NoteViewHolder>(noteCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding: NoteItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.note_item,
            parent,
            false
        )

        return NoteViewHolder(binding, onNoteClick)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class NoteViewHolder(
    private val noteItemBinding: NoteItemBinding,
    private val onNoteClick: (Note, View) -> Unit
) : RecyclerView.ViewHolder(noteItemBinding.root) {

    fun bind(note: Note) {
        noteItemBinding.note = note
        itemView.setOnClickListener {
            Timber.d("on item view clicked")
            onNoteClick.invoke(note, it)
        }
    }
}