package co.edu.unbosque.Taller5Prog.jpa.repositories;

import co.edu.unbosque.Taller5Prog.jpa.entities.Author;
import co.edu.unbosque.Taller5Prog.jpa.entities.Book;
import co.edu.unbosque.Taller5Prog.jpa.entities.Edition;
import co.edu.unbosque.Taller5Prog.jpa.entities.Library;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {

    private EntityManager entityManager;

    public BookRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Book> findById(Integer id) {
        Book book = entityManager.find(Book.class, id);
        return book != null ? Optional.of(book) : Optional.empty();
    }

    public Optional<Book> findByTitle(String title) {
        Book book = entityManager.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class)
                .setParameter("title", title)
                .getSingleResult();
        return book != null ? Optional.of(book) : Optional.empty();
    }

    public Optional<Book> findByTitleNamedQuery(String title) {
        Book book = entityManager.createNamedQuery("Book.findByTitle", Book.class)
                .setParameter("title", title)
                .getSingleResult();
        return book != null ? Optional.of(book) : Optional.empty();
    }

    public List<Book> findAll() {
        return entityManager.createQuery("from Book").getResultList();
    }

    public Optional<Book> save(Book book) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();
            return Optional.of(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();


    }

    @Override
    public void delete(Integer id){
        Book bookAux = entityManager.find(Book.class,id);
        Author autor = bookAux.getAuthor();
        if(autor!=null){
            try{
                entityManager.getTransaction().begin();
                autor.deleteBook(bookAux);
                entityManager.getTransaction().commit();

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }



    public void modificar(int id,String newName, String newIsbn, String newGener){
        Book bookAux = entityManager.find(Book.class,id);
        if(bookAux!=null){
            try {
                entityManager.getTransaction().begin();
                bookAux.setTitle(newName);
                bookAux.setIsbn(newIsbn);
                bookAux.setGenre(newGener);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }


}
