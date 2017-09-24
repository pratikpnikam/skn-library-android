package com.example.myfirstapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myfirstapp.R;

public class SearchResultActivity extends AppCompatActivity {

    private RelativeLayout mFoundContainer;
    private RelativeLayout mNotFoundContainer;
    private TextView mPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        mFoundContainer = findViewById(R.id.found);
        mNotFoundContainer = findViewById(R.id.not_found);
        mPath = findViewById(R.id.book_path);

        if(!getIntent().hasExtra("row")) {
            mNotFoundContainer.setVisibility(View.VISIBLE);
        } else {
            mFoundContainer.setVisibility(View.VISIBLE);
            String row = getIntent().getStringExtra("row");
            String shelf = getIntent().getStringExtra("shelf");
            mPath.setText(String.format("%s %s", row, shelf));
        }
    }
}
