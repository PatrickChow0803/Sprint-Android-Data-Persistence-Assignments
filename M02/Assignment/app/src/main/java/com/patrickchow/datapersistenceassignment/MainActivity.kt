package com.patrickchow.datapersistenceassignment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.patrickchow.datapersistenceassignment.adapter.BooksAdapter
import com.patrickchow.datapersistenceassignment.model.Book
import com.patrickchow.datapersistenceassignment.model.BooksModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

        companion object {

            const val ADD_BOOK = 1
            const val EDIT_BOOK = 2
            const val USER_PREFERENCE = "user_preferences"
            const val ID_KEY = "id-key"
            const val STRING_KEY = "string-key"
            val sharedPrefsDao = SharedPrefsDao()

            var bookList = mutableListOf<Book>()

            lateinit var preferences: SharedPreferences
        }

        lateinit var adapter: BooksAdapter



        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            preferences = this.getSharedPreferences(
                USER_PREFERENCE, Context.MODE_PRIVATE)

            BooksModel.updateBookList()
            sharedPrefsDao.saveAllBookCvs()
            sharedPrefsDao.saveAllIds()

            recycler_view.setHasFixedSize(true)
            val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            adapter = BooksAdapter(bookList)
            recycler_view.layoutManager = manager
            recycler_view.adapter = adapter

            btn_add.setOnClickListener {
                val intent = Intent(this, EditBookActivity::class.java)
                intent.putExtra(ID_KEY, bookList.size.toString())
                startActivityForResult(intent, ADD_BOOK)
            }
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == ADD_BOOK && resultCode == Activity.RESULT_OK) {
                val bookCSV = data?.getStringExtra(STRING_KEY)
                if (bookCSV != null) {
                    val book = Book(bookCSV)
                    bookList.add(book)
                    adapter.notifyDataSetChanged()

                    sharedPrefsDao.saveAllBookCvs()
                    sharedPrefsDao.saveAllIds()
                }
                else
                    Toast.makeText(this, "Failure on onActivityResult 1", Toast.LENGTH_SHORT).show()
            }
            if (requestCode == EDIT_BOOK && resultCode == Activity.RESULT_OK) {
                BooksModel.handleEditActivityResult(data!!)
                adapter.notifyDataSetChanged()

            }
        }
}

