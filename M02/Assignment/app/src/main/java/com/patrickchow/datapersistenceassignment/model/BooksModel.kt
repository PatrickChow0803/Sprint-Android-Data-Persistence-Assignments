package com.patrickchow.datapersistenceassignment.model


import android.content.Intent
import com.patrickchow.datapersistenceassignment.MainActivity
import com.patrickchow.datapersistenceassignment.SharedPrefsDao

class BooksModel {
    companion object{

        fun updateBookList() {
            val idList = MainActivity.sharedPrefsDao.getAllBookIds()
            val oldIdList = idList.split(",")
            val listOfIds = ArrayList<String>(oldIdList.size)
            if (idList.isNotBlank()) {
                listOfIds.addAll(oldIdList)
            }
            listOfIds.forEach {
                val csvString = MainActivity.sharedPrefsDao.getBookCSV(it)
                MainActivity.sharedPrefsDao.updateBook(Book(csvString))
            }
        }

        fun handleEditActivityResult(intent: Intent){
            val bookCSV = intent.getStringExtra(MainActivity.STRING_KEY)
            if(bookCSV != null) {
                val book = Book(bookCSV)
                val index = book.id
                MainActivity.bookList[index!!.toInt()] = book
                MainActivity.sharedPrefsDao.saveAllBookCvs()
                MainActivity.sharedPrefsDao.saveAllIds()
            }
        }
    }
}