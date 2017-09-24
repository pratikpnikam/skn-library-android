package com.example.myfirstapp.models;


import io.realm.RealmList;
import io.realm.RealmObject;

public class BookShelf extends RealmObject {
    private int mId;
    private String mName;
    private RealmList<Book> mBooks;

    public BookShelf() {
        mBooks = new RealmList<>();
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public RealmList<Book> getBooks() {
        return mBooks;
    }

    public void setBooks(RealmList<Book> books) {
        mBooks = books;
    }
}
