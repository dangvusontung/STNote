package sontung.dangvu.stnote.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.components.FragmentComponent
import sontung.dangvu.stnote.db.AppDatabase
import sontung.dangvu.stnote.db.note.NoteDao
import sontung.dangvu.stnote.ui.note.NoteRepository
import sontung.dangvu.stnote.ui.note.NoteRepositoryProvider
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDb(application: Application) : AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            "note_db"
        ).build()
    }

    @Provides
    fun provideNoteDao(db : AppDatabase) = db.noteDao()

    @Provides
    fun provideNoteRepository(dao: NoteDao) : NoteRepositoryProvider {
        return NoteRepositoryProvider(dao)
    }
}

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindNoteViewModel(noteRepositoryProvider: NoteRepositoryProvider) : NoteRepository
}