package src.main.java.org.colecciones.entidades;

public record Book (String isbn, String title, String author, int pages) implements Comparable<Book>{
    public Book(String isbn, String title, String author, int pages) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }
    public Book() {
        this("12345678", "biografia", "yo", 300);
    }

    @java.lang.Override
    public String isbn() {
        return isbn;
    }

    @java.lang.Override
    public String title() {
        return title;
    }

    @java.lang.Override
    public String author() {
        return author;
    }

    @java.lang.Override
    public int pages() {
        return pages;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }
    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }
}
