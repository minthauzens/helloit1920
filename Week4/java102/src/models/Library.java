package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Library {
    private ArrayList<Book> books;
//    private LinkedList<Book> books;

    public Library(ArrayList<Book> books) {
//        if (books == null) {
//            throw new Exception("Books cannot be null");
//        }
        this.books = books;
    }

    public Library(int size) throws Exception {
        if (size <= 0) {
            throw new Exception("Library size must be bigger than 0");
        }
        this.books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public Book getBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equals(title)) {
                books.remove(i);
                return book;
            }
        }
        return null;
    }

    public void storeBook(Book book) {
        this.books.add(book);
    }

    public void addNewBooks(ArrayList<Book> newBooks) {
        books.addAll(newBooks);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
