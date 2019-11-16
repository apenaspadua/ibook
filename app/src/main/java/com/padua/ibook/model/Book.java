package com.padua.ibook.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import javax.security.auth.Destroyable;

@Entity
public class Book implements Serializable {
    private static Book mInstance;

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "author")
    private String author;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "readIt")
    private boolean readIt;

    public static synchronized Book getInstance(){
        if(mInstance == null) mInstance = new Book();

        return mInstance;
    }

    public Book(int i, String steam, double y, String personal, String s){}
    public Book(){}

    @Ignore
    public Book(String name, String author, String description, boolean readIt){
        this.name = name;
        this.author = author;
        this.description = description;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isReadIt() {
        return readIt;
    }

    public void setReadIt(boolean readIt) {
        this.readIt = readIt;
    }

    @NonNull
    @Override
    public  String toString(){return  super.toString();}
}
