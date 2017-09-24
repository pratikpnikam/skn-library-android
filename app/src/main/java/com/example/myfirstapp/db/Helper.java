package com.example.myfirstapp.db;

import android.content.Context;
import android.util.Log;

import com.example.myfirstapp.models.Book;
import com.example.myfirstapp.models.BookShelf;
import com.example.myfirstapp.models.Library;
import com.example.myfirstapp.models.Row;

import io.realm.Realm;
import io.realm.RealmList;

public class Helper {

    public static void createAndInsert(Context context) {
        Realm.init(context);
        Realm.getDefaultInstance().beginTransaction();
        RealmList<Row> rows = new RealmList<>();

        final Library library = Realm.getDefaultInstance().createObject(Library.class);
        library.setName("SKNCOE Library");
        library.setId(1);

        final Row row1 = Realm.getDefaultInstance().createObject(Row.class);
        row1.setId(1);
        row1.setName("Row 1");
        row1.setBookShelves(getComputerBookShelves());

        rows.add(row1);
        library.setRows(rows);
        Realm.getDefaultInstance().commitTransaction();
        Log.d("###Helper", "Created DB successfully!!");
    }

    private static RealmList<BookShelf> getComputerBookShelves() {
        RealmList<BookShelf> bookShelves = new RealmList<>();

        BookShelf bookShelf1 = Realm.getDefaultInstance().createObject(BookShelf.class);
        bookShelf1.setId(1);
        bookShelf1.setName("Computer");
        bookShelf1.setBooks(getComputerBooks());

        BookShelf bookShelf2 = Realm.getDefaultInstance().createObject(BookShelf.class);
        bookShelf2.setId(2);
        bookShelf2.setName("Mechanical");
        bookShelf2.setBooks(getMechanicalBooks());

        BookShelf bookShelf3 = Realm.getDefaultInstance().createObject(BookShelf.class);
        bookShelf3.setId(3);
        bookShelf3.setName("Electronics");
        bookShelf3.setBooks(getElectronicsBooks());

        BookShelf bookShelf4 = Realm.getDefaultInstance().createObject(BookShelf.class);
        bookShelf4.setId(4);
        bookShelf4.setName("Civil");
        bookShelf4.setBooks(getCivilBooks());

        /*bookShelves[0] = bookShelf1;
        bookShelves[1] = bookShelf2;
        bookShelves[2] = bookShelf3;
        bookShelves[3] = bookShelf4;*/
        bookShelves.add(bookShelf1);
        bookShelves.add(bookShelf2);
        bookShelves.add(bookShelf3);
        bookShelves.add(bookShelf4);
        return bookShelves;
    }


    private static RealmList<Book> getComputerBooks() {
        RealmList<Book> books = new RealmList<>();

        Book book1 = Realm.getDefaultInstance().createObject(Book.class);
        book1.setId(1);
        book1.setName("C");
        book1.setAuthor("Some Author1");

        Book book2 = Realm.getDefaultInstance().createObject(Book.class);
        book2.setId(2);
        book2.setName("C++");
        book2.setAuthor("Some Author");

        Book book3 = Realm.getDefaultInstance().createObject(Book.class);
        book3.setId(3);
        book3.setName("Java");
        book3.setAuthor("Some Author2");

        Book book4 = Realm.getDefaultInstance().createObject(Book.class);
        book4.setId(4);
        book4.setName("Data structure");
        book4.setAuthor("Some Author3");

        Book book5 = Realm.getDefaultInstance().createObject(Book.class);
        book5.setId(5);
        book5.setName("Software Engineering");
        book5.setAuthor("Some Author4");

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        return books;
    }

    private static RealmList<Book> getMechanicalBooks() {
        RealmList<Book> books = new RealmList<>();

        Book book1 = Realm.getDefaultInstance().createObject(Book.class);
        book1.setId(6);
        book1.setName("Theory of Machines");
        book1.setAuthor("Some Author1");

        Book book2 = Realm.getDefaultInstance().createObject(Book.class);
        book2.setId(7);
        book2.setName("Strength of materials");
        book2.setAuthor("Some Author");

        Book book3 = Realm.getDefaultInstance().createObject(Book.class);
        book3.setId(8);
        book3.setName("Mathematics");
        book3.setAuthor("Some Author2");

        Book book4 = Realm.getDefaultInstance().createObject(Book.class);
        book4.setId(9);
        book4.setName("Graphics");
        book4.setAuthor("Some Author3");

        Book book5 = Realm.getDefaultInstance().createObject(Book.class);
        book5.setId(10);
        book5.setName("Fluid Mechanics");
        book5.setAuthor("Some Author4");

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        return books;
    }

    private static RealmList<Book> getElectronicsBooks() {
        RealmList<Book> books = new RealmList<>();

        Book book1 = Realm.getDefaultInstance().createObject(Book.class);
        book1.setId(11);
        book1.setName("Digital Electronics");
        book1.setAuthor("Some Author1");

        Book book2 = Realm.getDefaultInstance().createObject(Book.class);
        book2.setId(12);
        book2.setName("Signals & Systems");
        book2.setAuthor("Some Author");

        Book book3 = Realm.getDefaultInstance().createObject(Book.class);
        book3.setId(13);
        book3.setName("Control Systems");
        book3.setAuthor("Some Author2");

        Book book4 = Realm.getDefaultInstance().createObject(Book.class);
        book4.setId(14);
        book4.setName("Electronic Devices");
        book4.setAuthor("Some Author3");

        Book book5 = Realm.getDefaultInstance().createObject(Book.class);
        book5.setId(15);
        book5.setName("Engineering Mathematics");
        book5.setAuthor("Some Author4");

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        return books;
    }

    private static RealmList<Book> getCivilBooks() {
        RealmList<Book> books = new RealmList<>();

        Book book1 = Realm.getDefaultInstance().createObject(Book.class);
        book1.setId(16);
        book1.setName("Hydrology");
        book1.setAuthor("Some Author1");

        Book book2 = Realm.getDefaultInstance().createObject(Book.class);
        book2.setId(17);
        book2.setName("Structural design");
        book2.setAuthor("Some Author");

        Book book3 = Realm.getDefaultInstance().createObject(Book.class);
        book3.setId(18);
        book3.setName("Mathematics");
        book3.setAuthor("Some Author2");

        Book book4 = Realm.getDefaultInstance().createObject(Book.class);
        book4.setId(19);
        book4.setName("Infrastructural Engineering");
        book4.setAuthor("Some Author3");

        Book book5 = Realm.getDefaultInstance().createObject(Book.class);
        book5.setId(20);
        book5.setName("Foundation Engineering");
        book5.setAuthor("Some Author4");

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        return books;
    }

    public static Library getLibrary() {
        Realm.getDefaultInstance().beginTransaction();
        Library library = Realm.getDefaultInstance()
                .where(Library.class)
                .equalTo("mName",
                "SKNCOE Library").findFirst();
        Realm.getDefaultInstance().commitTransaction();
        return library;
    }


}
