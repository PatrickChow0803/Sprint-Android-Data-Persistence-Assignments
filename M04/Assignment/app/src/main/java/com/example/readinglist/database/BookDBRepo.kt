package com.example.readinglist.database

import android.content.Context
import androidx.room.Room
import com.example.readinglist.Book
import com.example.readinglist.BookRepoInterface

class BookDBRepo(val context: Context) : BookRepoInterface {

    private val contxt = context.applicationContext

    override fun createBook(book: Book) {
        database.entriesDao().createBook(book)
    }

    override fun readAllBooks(): MutableList<Book> {
        return database.entriesDao().readAllBooks()
    }

    override fun updateBook(book: Book) {
        database.entriesDao().updateBook(book)
    }

    override fun deleteBook(book: Book) {
        database.entriesDao().deleteBook(book)
    }


    private val database by lazy {
        Room.databaseBuilder(
            contxt,
            BookEntryDB::class.java,
            "entry_database"
        ).fallbackToDestructiveMigration().build()
    }
}