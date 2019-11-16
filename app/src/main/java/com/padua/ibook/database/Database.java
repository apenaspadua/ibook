package com.padua.ibook.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.padua.ibook.database.dao.BookDao;
import com.padua.ibook.model.Book;

import java.util.List;

import io.reactivex.Flowable;

@androidx.room.Database(entities = {Book.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase implements DatabaseContract {

    private static Database mInstance;
    private DatabaseContract mLocalDatabase;

    public abstract BookDao bookDao();

    public static Database getInstance(Context context){
        if(mInstance == null)
            mInstance = Room.databaseBuilder(context, Database.class,
                    "booksDB").allowMainThreadQueries().build();

        return mInstance;
    }

    @Override
    public Flowable<List<Book>> getAllBooks() {
        return mLocalDatabase.getAllBooks();
    }

    @Override
    public void insertBook(Book... books) {
        mLocalDatabase.insertBook();
    }

    @Override
    public void deleteBook(Book... books) {
        mLocalDatabase.deleteBook();
    }
}
