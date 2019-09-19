package com.example.readinglist.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.readinglist.Book

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BookEntryDB : RoomDatabase(){
    abstract fun entriesDao(): BookEntryDAO
}