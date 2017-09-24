package com.example.myfirstapp.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Row extends RealmObject {
    private int mId;
    private String mName;
    private RealmList<BookShelf> mBookShelves;

    public Row() {
        mBookShelves = new RealmList<>();
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

    public RealmList<BookShelf> getBookShelves() {
        return mBookShelves;
    }

    public void setBookShelves(RealmList<BookShelf> bookShelves) {
        mBookShelves = bookShelves;
    }
}
