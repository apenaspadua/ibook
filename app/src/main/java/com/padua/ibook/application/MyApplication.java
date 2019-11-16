package com.padua.ibook.application;

import android.app.Application;

import com.padua.ibook.database.Database;
import com.padua.ibook.model.Book;

import java.util.List;

public class MyApplication extends Application {
    private Database db;

    @Override
    public void onCreate() {
        super.onCreate();

        db = Database.getInstance(getApplicationContext());
    }

    public MyApplication(){}

    public List<Book> getAllBooks(){
        return db.bookDao().getAllBooks();
    }

    public boolean insertBook(final Book book){
        try {
            db.bookDao().insertBook(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteBook(final Book book){
        try {
            db.bookDao().deleteBook(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
