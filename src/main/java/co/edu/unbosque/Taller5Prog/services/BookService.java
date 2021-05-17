package co.edu.unbosque.Taller5Prog.services;

import co.edu.unbosque.Taller5Prog.jpa.entities.Author;
import co.edu.unbosque.Taller5Prog.jpa.entities.Book;
import co.edu.unbosque.Taller5Prog.jpa.repositories.AuthorRepositoryImpl;
import co.edu.unbosque.Taller5Prog.jpa.repositories.BookRepositoryImpl;
import co.edu.unbosque.Taller5Prog.servlets.pojos.BookPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class BookService {

    AuthorRepositoryImpl authorRepository;
    BookRepositoryImpl bookRepository;
    EditionService editionService;


    public List<BookPOJO> listBooks() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        bookRepository = new BookRepositoryImpl(entityManager);
        List<Book> books = bookRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<BookPOJO> booksPOJO = new ArrayList<>();

        for (Book book : books) {
            booksPOJO.add(new BookPOJO(book.getBookId(), book.getTitle(), book.getIsbn(), book.getGenre()));
        }

        return booksPOJO;
    }

    public void saveBook(String title, String isbn, Integer authorId, String genero) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        bookRepository = new BookRepositoryImpl(entityManager);

        Optional<Author> author = authorRepository.findById(authorId);
        author.ifPresent(a -> {
            a.addBook(new Book(title, isbn, genero));
            authorRepository.save(a);
        });

        entityManager.close();
        entityManagerFactory.close();

        return;

    }

    public void deleteBook(Integer id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        bookRepository = new BookRepositoryImpl(entityManager);
        bookRepository.delete(id);

        entityManager.close();
        entityManagerFactory.close();
    }

    public void modificarLibro(int id, String newName, String newIsbn, String newGener) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        bookRepository = new BookRepositoryImpl(entityManager);
        bookRepository.modificar(id, newName, newIsbn, newGener);

        entityManager.close();
        entityManagerFactory.close();
    }

}
