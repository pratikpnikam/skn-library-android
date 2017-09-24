package com.example.myfirstapp.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfirstapp.R;
import com.example.myfirstapp.db.Helper;
import com.example.myfirstapp.models.Book;
import com.example.myfirstapp.models.BookShelf;
import com.example.myfirstapp.models.Library;
import com.example.myfirstapp.models.Row;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "##MainActivity";
    private EditText mNameEditText;
    private Button mSearchButton;
    private Toast mToast;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler = new Handler();
        mNameEditText = findViewById(R.id.editText);
        mSearchButton = findViewById(R.id.search);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Search button clicked");
                if(mNameEditText.getText().toString().isEmpty()) {
                    mNameEditText.setError("Book name required");
                    return;
                }
                search(mNameEditText.getText().toString());
            }
        });

        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mNameEditText.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void search(final String bookName) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Library library = Helper.getLibrary();
                if(library == null) {
                    showToast("Library not found");
                    return;
                }
                boolean found = false;
                List<Row> rows = library.getRows();
                Row foundRow = null;
                BookShelf shelf = null;
                for(Row row : rows) {
                    if(row == null) {
                        continue;
                    }
                    List<BookShelf> bookShelves = row.getBookShelves();
                    for(BookShelf bookShelf : bookShelves) {
                        for(Book book : bookShelf.getBooks()) {
                            if (book.getName().toLowerCase().contains(bookName.toLowerCase())) {
                                Log.d(TAG, "Found at " + row.getName() + " : " + bookShelf.getName());
                                found = true;
                                foundRow = row;
                                shelf = bookShelf;
                                break;
                            }
                        }
                    }
                }
                Intent intent = new Intent(getApplicationContext(), SearchResultActivity.class);
                if(found) {
                    Log.d(TAG, "Found!!");
                    intent.putExtra("row", foundRow.getName());
                    intent.putExtra("shelf", shelf.getName());
                } else {
                    Log.d(TAG, "Not Found!!");
                }
                startActivity(intent);
            }
        }).start();
    }

    private void showToast(final String text) {
        Log.d(TAG,  text);
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if(mToast == null) {
                    mToast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                }
                mToast.cancel();
                mToast.show();
            }
        });

    }
}
