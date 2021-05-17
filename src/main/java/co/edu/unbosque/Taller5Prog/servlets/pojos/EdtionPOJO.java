package co.edu.unbosque.Taller5Prog.servlets.pojos;

import java.util.Date;

public class EdtionPOJO {

    private int edition_id;
    private String descripcion;
    private Date release_year;
    private int book_id;
    private String libro;

    public EdtionPOJO(int edition_id, String descripcion, Date release_year, int book_id ,String libro) {
        this.edition_id = edition_id;
        this.descripcion = descripcion;
        this.release_year = release_year;
        this.book_id = book_id;
        this.libro = libro;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public int getEdition_id() {
        return edition_id;
    }

    public void setEdition_id(int edtition_id) {
        this.edition_id = edtition_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Date release_year) {
        this.release_year = release_year;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Override
    public String toString() {
        return "EdtionPOJO{" +
                "edtition_id=" + edition_id +
                ", descripcion='" + descripcion + '\'' +
                ", release_year=" + release_year +
                ", book_id=" + book_id +
                '}';
    }
}
