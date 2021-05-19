package co.edu.unbosque.Taller5Prog.jpa.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Edition") // Optional
@NamedQueries({
        @NamedQuery(name = "Edition.findAll",
                query = "SELECT b FROM Edition b")
})
public class Edition {

    @Id
    @GeneratedValue
    @Column(name = "edition_id")
    private Integer editionId;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Date releaseYear;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToMany(mappedBy = "editions", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Library> libraries = new HashSet<>();

    @OneToMany(mappedBy = "edition", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rent> rents = new ArrayList<>();

    public Edition() {
    }


    public Edition(String description, Date releaseYear) {
        this.description = description;
        this.releaseYear = releaseYear;
    }

    public void addLibrary(Library library){
        libraries.add(library);
        library.addEdition(this);
    }

    public void removeLibrary(Library library){
        boolean bandera = false;
        for(Library l:libraries){
            if(l.getLibraryId()==library.getLibraryId()){
                bandera = true;
                break;
            }
        }
        if(bandera){
            libraries.remove(library);
            library.removeEdition(this);
        }
    }

    public Integer getEditionId() {
        return editionId;
    }

    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Set<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(Set<Library> libraries) {
        this.libraries = libraries;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }
}


