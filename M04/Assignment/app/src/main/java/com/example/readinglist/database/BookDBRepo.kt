package com.example.readinglist.database

import com.example.readinglist.Book
import com.example.readinglist.BookRepoInterface

class BookDBRepo : BookRepoInterface {
    override fun createBook(book: Book) {

    }

    override fun readAllBooks(): MutableList<Book> {
        return mutableListOf()
    }

    override fun updateBook(book: Book) {
    }

    override fun deleteBook(book: Book) {
    }

}