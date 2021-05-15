package co.edu.unbosque.Taller5Prog.jpa.repositories;

import co.edu.unbosque.Taller5Prog.jpa.entities.Library;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class LibraryRepositoryImpl implements LibraryRepository {

    private EntityManager entityManager;

    public LibraryRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Library> findAll() {
        return entityManager.createQuery("from Library").getResultList();
    }


    public Optional<Library> save(Library library) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(library);
            entityManager.getTransaction().commit();
            return Optional.of(library);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void modificar(int id, String newName) {
        Library library = entityManager.find(Library.class, id);
        if (library != null) {
            try {
                entityManager.getTransaction().begin();
                library.setName(newName);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int id) {
        Library library = entityManager.find(Library.class, id);
        if (library != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(library);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }
}
