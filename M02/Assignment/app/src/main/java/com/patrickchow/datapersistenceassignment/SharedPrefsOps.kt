package com.patrickchow.datapersistenceassignment

import android.content.Context
import android.content.SharedPreferences
import com.patrickchow.datapersistenceassignment.model.Book

class SharedPrefOperations(private val context: Context): BookInterface{

    lateinit var preferences: SharedPreferences

    private val sharedPrefsDao = SharedPrefsDao()

    override fun saveAllIds() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBookCSV(id: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateBook(book: Book) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveAllBookCvs() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllBookIds(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}