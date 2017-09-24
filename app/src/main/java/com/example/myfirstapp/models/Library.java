package com.example.myfirstapp.models;


import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Library extends RealmObject {
    private int mId;
    private String mName;
    private RealmList<Row> mRows;

    public Library() {
        mRows = new RealmList<>();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public List<Row> getRows() {
        return mRows;
    }

    public void setRows(RealmList<Row> rows) {
        mRows = rows;
    }
}
