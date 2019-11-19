package models;

public class Book {
    /*
     * Object-orientated programming
     *
     * */

    /*
     * public -
     * protected
     * default - don't need to write this
     * private
     */

    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) throws Exception {
        if (title == null) {
            throw new Exception("Title can not be null!");
        }
        if (author == null) {
            throw new Exception("Author can not be null!");
        }
        if (isbn == null) {
            throw new Exception("Isbn can not be null!");
        }


        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "models.Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
