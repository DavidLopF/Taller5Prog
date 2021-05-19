package co.edu.unbosque.Taller5Prog.jpa.repositories;

import co.edu.unbosque.Taller5Prog.jpa.entities.Customer;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

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
        Customer customer = entityManager.find(Customer.class, email);
        try {
            entityManager.getTransaction().begin();
            customer.setFirst_name(first_name);
            customer.setLast_name(last_name);
            customer.setGender(gender);
            customer.setAge(age);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(String email) {
        Customer customer = entityManager.find(Customer.class, email);
        try {
            entityManager.getTransaction().begin();

            customer.getRents().forEach(rent -> {
                        entityManager.remove(rent);
                    }
            );

            entityManager.remove(customer);
            entityManager.getTransaction().commit();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("FROM Customer ").getResultList();
    }

    @Override
    public Optional<Customer> findById(String id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer != null ? Optional.of(customer) : Optional.empty();
    }
}
