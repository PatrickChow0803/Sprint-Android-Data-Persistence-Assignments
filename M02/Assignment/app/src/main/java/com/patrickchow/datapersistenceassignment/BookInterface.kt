package com.patrickchow.datapersistenceassignment

import com.patrickchow.datapersistenceassignment.model.Book

interface BookInterface{
    
    fun createEntry(entry: Book)
    fun updateEntry(entry: Book)
    fun readAllEntries(): MutableList<Book>
    fun deleteEntry(entry: Book)
}