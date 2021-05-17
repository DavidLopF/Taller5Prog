package co.edu.unbosque.Taller5Prog.servlets.pojos;

public class BookPOJO {

    private int bookId;
    private String title;
    private String isbn_number;
    private String genre;

    public BookPOJO(int bookId, String title, String isbn_number, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.isbn_number = isbn_number;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn_number() {
        return isbn_number;
    }

    public void setIsbn_number(String isbn_number) {
        this.isbn_number = isbn_number;
    }
}
