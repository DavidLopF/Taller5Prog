package co.edu.unbosque.Taller5Prog.jpa.repositories;

import co.edu.unbosque.Taller5Prog.jpa.entities.Author;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class AuthorRepositoryImpl implements AuthorRepository {

    private EntityManager entityManager;

    public AuthorRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Author> findById(Integer id) {
        Author author = entityManager.find(Author.class, id);
        return author != null ? Optional.of(author) : Optional.empty();
    }
    public List<Author> findAll() {
        return entityManager.createQuery("from Author").getResultList();
    }



    public Optional<Author> findByName(String name) {
        Author author = entityManager.createNamedQuery("Author.findByName", Author.class)
                .setParameter("name", name)
                .getSingleResult();
        return author != null ? Optional.of(author) : Optional.empty();
    }

    public Optional<Author> save(Author author) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(author);
            entityManager.getTransaction().commit();
            return Optional.of(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Author encontrar(Integer id){
        Author author = entityManager.find(Author.class,id);
        return author;
    }



    @Override
    public void deleteById(Integer id) {
        Author author = entityManager.find(Author.class, id);
        if (author != null) {
            try {

                entityManager.getTransaction().begin();

                author.getBooks().forEach(book -> {
                    entityManager.remove(book);
                });

                entityManager.remove(author);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void modificar(int id,String fullname, String country) {
        Author authorAux = entityManager.find(Author.class,id);
        if(authorAux!=null){
            try {
                entityManager.getTransaction().begin();
                authorAux.setName(fullname);
                authorAux.setCountry(country);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

}
