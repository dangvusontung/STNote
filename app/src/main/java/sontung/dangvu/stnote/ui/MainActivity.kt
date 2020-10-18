package sontung.dangvu.stnote.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import sontung.dangvu.stnote.R
import sontung.dangvu.stnote.ui.note.NoteViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val noteViewModel : NoteViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}