package co.edu.unbosque.Taller5Prog.jpa.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Library") // Optional
public class Library {

    @Id
    @GeneratedValue
    @Column(name = "library_id")
    private Integer libraryId;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Library_Edition",
            joinColumns = {@JoinColumn(name = "library_id")},
            inverseJoinColumns = {@JoinColumn(name = "edition_id")}
    )

    private Set<Edition> editions = new HashSet<>();


    public Library() {
    }

    public Library(Integer libraryId, String name) {
        this.libraryId = libraryId;
        this.name = name;
    }

    public Library(String name) {
        this.name = name;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
