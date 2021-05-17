package co.edu.unbosque.Taller5Prog.services;


import co.edu.unbosque.Taller5Prog.jpa.entities.Book;
import co.edu.unbosque.Taller5Prog.jpa.entities.Edition;
import co.edu.unbosque.Taller5Prog.jpa.repositories.BookRepositoryImpl;
import co.edu.unbosque.Taller5Prog.jpa.repositories.EditionRepostoryImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.Optional;

@Stateless
public class EditionService {

    EditionRepostoryImpl editionRepository;
    BookRepositoryImpl bookRepository;

    public void saveEdition(String descripcion, Date year, int book_Id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        bookRepository = new BookRepositoryImpl(entityManager);
        editionRepository = new EditionRepostoryImpl(entityManager);

        Optional<Book> book = bookRepository.findById(book_Id);
        book.ifPresent(temp-> {
            temp.addEdition(new Edition(descripcion, year));
            bookRepository.save(temp);
        });

        entityManager.close();
        entityManagerFactory.close();


    }
}
