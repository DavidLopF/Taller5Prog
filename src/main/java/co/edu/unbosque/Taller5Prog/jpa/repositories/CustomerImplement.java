package co.edu.unbosque.Taller5Prog.jpa.repositories;

import co.edu.unbosque.Taller5Prog.jpa.entities.Customer;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerImplement implements CustomerRepository {

    private EntityManager entityManager;

    public CustomerImplement(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public void save(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String email, String first_name, String last_name, String gender, int age) {

    }

    @Override
    public void delete(String email) {

    }

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("FROM Customer ").getResultList();
    }
}
