package com.patrickchow.datapersistenceassignment

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.patrickchow.datapersistenceassignment.model.Book
import kotlinx.android.synthetic.main.activity_edit_book.*

class EditBookActivity : AppCompatActivity() {


    private var hasBeenRead = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_book)

        var id = intent.getStringExtra(MainActivity.ID_KEY)

        var bookCSV = intent.getStringExtra(MainActivity.STRING_KEY)
        var book: Book? = if (bookCSV != null)
            Book(bookCSV)
        else
            null

        if (book != null){
            cb_read.isChecked = book.hasBeenRead
            hasBeenRead = book.hasBeenRead
            id = book.id
            et_title.setText(book.title)
            et_reason.setText(book.reasonToRead)
        }else{
            cb_read.isChecked = false
        }

        cb_read.setOnClickListener {
            hasBeenRead = !hasBeenRead
        }

        fun returnData(): String{
            val title = et_title.text.toString()
            val reason = et_reason.text.toString()
            book = Book(title, reason, hasBeenRead, id ?: MainActivity.bookList.size.toString())
            return book?.toCvsString() ?: "Nope"
        }
        btn_save.setOnClickListener {
            val saveIntent = Intent(this, MainActivity::class.java)
            saveIntent.putExtra(MainActivity.STRING_KEY, returnData())
            setResult(Activity.RESULT_OK, saveIntent)
            finish()
        }
        btn_cancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}

