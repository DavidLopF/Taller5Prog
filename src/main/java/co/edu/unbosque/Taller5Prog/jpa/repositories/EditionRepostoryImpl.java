package co.edu.unbosque.Taller5Prog.jpa.repositories;

import co.edu.unbosque.Taller5Prog.jpa.entities.Book;
import co.edu.unbosque.Taller5Prog.jpa.entities.Edition;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class EditionRepostoryImpl implements EditionRepository {

    private EntityManager entityManager;

    public EditionRepostoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Edition> save(Edition editon) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(editon);
            entityManager.getTransaction().commit();
            return Optional.of(editon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Edition> findOneById(int id){
        return entityManager.createQuery("from Edition where book.id = "+id).getResultList();
    }

    @Override
    public List<Edition> findAll() {
        return entityManager.createQuery("FROM Edition").getResultList();
    }

    public Optional<Edition> update(String desc, Date date, int id) {
        Edition edition = entityManager.find(Edition.class, id);
        try {
            entityManager.getTransaction().begin();
            edition.setDescription(desc);
            edition.setReleaseYear(date);
            entityManager.getTransaction().commit();
            return Optional.of(edition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    public Optional<Edition> delete(int id) {
        Edition edition = entityManager.find(Edition.class, id);
        Book book = edition.getBook();
        try {
            entityManager.getTransaction().begin();
            book.deleteEdition(edition);
            entityManager.getTransaction().commit();
            return Optional.of(edition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
