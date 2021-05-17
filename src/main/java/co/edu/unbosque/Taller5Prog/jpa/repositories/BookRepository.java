package co.edu.unbosque.Taller5Prog.jpa.repositories;

import co.edu.unbosque.Taller5Prog.jpa.entities.Book;
import co.edu.unbosque.Taller5Prog.jpa.entities.Edition;


import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Optional<Book> findById(Integer id);

    Optional<Book> findByTitle(String title);

    Optional<Book> findByTitleNamedQuery(String title);

    List<Book> findAll();

    Optional<Book> save(Book book);



}
