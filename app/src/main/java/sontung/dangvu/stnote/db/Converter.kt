package sontung.dangvu.stnote.db

import androidx.room.TypeConverter
import java.util.*

class Converter {

    @TypeConverter
    fun fromLongToDate(timeStamp : Long) = Date(timeStamp)

    @TypeConverter
    fun fromDateToLong(date: Date) = date.time

    @TypeConverter
    fun booleanToInt(boolean: Boolean) = if (boolean) 1 else 0

    @TypeConverter
    fun intToBoolean(int : Int) = int == 1
}