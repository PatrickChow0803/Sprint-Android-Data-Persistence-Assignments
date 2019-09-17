package com.patrickchow.datapersistenceassignment.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patrickchow.datapersistenceassignment.EditBookActivity
import com.patrickchow.datapersistenceassignment.MainActivity
import com.patrickchow.datapersistenceassignment.R
import com.patrickchow.datapersistenceassignment.model.Book
import kotlinx.android.synthetic.main.book_recycler_item.view.*

class BooksAdapter(private val books: MutableList<Book>): RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    lateinit var context: Context //Make a context here so that it can be used in the entire class

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context //Get the context so that it can be used in the onBindViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = books[position]
        val textView = holder.txtTitle
        textView.text = book.title

        if(book.hasBeenRead){
            holder.llRecyclerView.setBackgroundColor(Color.CYAN)
        }
        else{
            holder.llRecyclerView.setBackgroundColor(Color.RED)
        }

        textView.setOnClickListener {
            val intent = Intent(context, EditBookActivity::class.java)
            intent.putExtra(MainActivity.STRING_KEY, book.toCvsString())
            (context as? Activity)?.startActivityForResult(intent, MainActivity.EDIT_BOOK)

        }
    }

    override fun getItemCount() = books.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var txtTitle = view.tv_title
        var llRecyclerView = view.ll_book_recycler
    }
}