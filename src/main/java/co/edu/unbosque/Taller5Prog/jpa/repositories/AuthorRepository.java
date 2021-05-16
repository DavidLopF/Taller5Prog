package co.edu.unbosque.Taller5Prog.jpa.repositories;

import co.edu.unbosque.Taller5Prog.jpa.entities.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    Optional<Author> findById(Integer id);

    List<Author> findAll();

    Optional<Author> save(Author author);

    void deleteById(Integer id);
    void modificar(int id, String fullname, String country);

    Author encontrar(Integer id);

}
