package sontung.dangvu.stnote.db.note

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "note_table")
data class Note (
    @ColumnInfo(name = "note_title") var title: String,
    @ColumnInfo(name = "note_content") var content: String,
) : Serializable {
    @PrimaryKey (autoGenerate = true) @ColumnInfo var id : Int = 0
    @ColumnInfo(name = "note_created_time") var timeCreated: Long = System.currentTimeMillis()

    override fun toString(): String {
        return "Note(title='$title', content='$content', id=$id, timeCreated=$timeCreated)"
    }


}