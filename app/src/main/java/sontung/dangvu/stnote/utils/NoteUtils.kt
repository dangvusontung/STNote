package sontung.dangvu.stnote.utils

import androidx.recyclerview.widget.DiffUtil
import sontung.dangvu.stnote.db.note.Note

val noteCallBack = object : DiffUtil.ItemCallback<Note>() {

    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.timeCreated == newItem.timeCreated
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.title == newItem.title && oldItem.content == newItem.content
    }

}