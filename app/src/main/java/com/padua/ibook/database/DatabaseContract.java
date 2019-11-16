package com.padua.ibook.database;

import com.padua.ibook.model.Book;
import java.util.List;
import io.reactivex.Flowable;

public interface DatabaseContract {

    Flowable<List<Book>> getAllBooks();
    void deleteBook(Book...books);
    void insertBook(Book...books);
}
