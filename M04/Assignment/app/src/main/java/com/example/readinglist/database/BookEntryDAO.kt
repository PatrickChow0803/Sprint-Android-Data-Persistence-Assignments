package com.example.readinglist.database

import androidx.room.*
import com.example.readinglist.Book

@Dao
interface BookEntryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createBook(book: Book)

    @Query("SELECT * FROM Book")
    fun readAllBooks(): MutableList<Book>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateBook(book: Book)

    @Delete
    fun deleteBook(book: Book)
}