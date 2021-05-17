package co.edu.unbosque.Taller5Prog.jpa.repositories;

import co.edu.unbosque.Taller5Prog.jpa.entities.Edition;

import javax.persistence.EntityManager;
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

    @Override
    public List<Edition> findAll() {
        return entityManager.createQuery("FROM Edition").getResultList();
    }
}
