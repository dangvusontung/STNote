package sontung.dangvu.stnote.base

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
abstract class BaseDao<T> where T : Any {
    @Insert
    abstract fun insert(t : T)

    @Update
    abstract fun update(t : T)

    @Delete
    abstract fun delete(t : T)


}