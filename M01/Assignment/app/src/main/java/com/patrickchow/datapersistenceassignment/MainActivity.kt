package com.patrickchow.datapersistenceassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.patrickchow.datapersistenceassignment.model.Book
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val listOfBooks = mutableListOf<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(bookIndex in bookData){
            //Using bookData, input the list with all the book data
            listOfBooks.add(bookIndex)
            //Add the books into the linear layout
            ll_books.addView(buildItemView(bookIndex))
        }

        btn_add.setOnClickListener {
            ll_books.addView(createTextView())
        }
    }

    fun createTextView(): TextView{
        val text = TextView(this)
        text.text = "HELLO"
        return text
    }

    //Creates the view to display information about the book
    fun buildItemView(book: Book): TextView {
        val view = TextView(this)
        view.text = book.title
        view.textSize = 30f
        return view
    }

    val bookData = mutableListOf<Book> (
        Book("Book1", "Reason1", false, "1"),
        Book("Book2", "Reason2", true, "2"),
        Book("Book3", "Reason3", false, "3"),
        Book("Book4", "Reason4", false, "4")
    )

}
