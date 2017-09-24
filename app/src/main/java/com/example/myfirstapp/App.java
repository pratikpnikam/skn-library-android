package com.example.myfirstapp;

import android.app.Application;

import com.example.myfirstapp.db.Helper;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Helper.createAndInsert(getApplicationContext());
    }
}
