package com.patrickchow.datapersistenceassignment

import com.patrickchow.datapersistenceassignment.model.Book

interface BookInterface{

    fun saveAllIds()
    fun getBookCSV(id: String): String
    fun updateBook(book: Book)

}