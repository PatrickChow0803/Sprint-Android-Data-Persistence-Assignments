package com.patrickchow.datapersistenceassignment

import com.patrickchow.datapersistenceassignment.model.Book

object SharedPrefsDao {

    const val ID_LIST = "id-list"

    fun saveAllIds() {
        var ids = ""
        for (index in MainActivity.bookList.indices) {
            if (MainActivity.bookList.size - 1 != index)
                    ids += "$index,"
        }
        MainActivity.preferences.edit()
            .putString(ID_LIST, ids)
            .apply()
    }

    fun saveAllBookCvs(){
        for (i in MainActivity.bookList.indices) {
            MainActivity.preferences.edit()
                .putString(MainActivity.bookList[i].id, MainActivity.bookList[i].toCvsString())
                .apply()
        }
    }

    fun getAllBookIds(): String {
        return MainActivity.preferences.getString(ID_LIST, "") ?: ""
    }

    fun getBookCSV(id: String): String {
        return MainActivity.preferences.getString(id, "") ?: ""
    }

    fun updateBook(book: Book) {
        var bookUpdated = false
        for (index in MainActivity.bookList.indices) {
            if (MainActivity.bookList[index].id == book.id) {
                MainActivity.bookList[index] = book
                bookUpdated = true
            }
        }
        if (!bookUpdated) {
            MainActivity.bookList.add(book)
        }
    }
}