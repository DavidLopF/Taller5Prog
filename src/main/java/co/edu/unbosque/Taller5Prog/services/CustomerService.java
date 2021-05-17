package co.edu.unbosque.Taller5Prog.services;

import co.edu.unbosque.Taller5Prog.jpa.entities.Customer;
import co.edu.unbosque.Taller5Prog.jpa.repositories.CustomerImplement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
public class CustomerService {

    CustomerImplement customerImplement;

    public void saveCustomer(String email, String firstName, String lastName, String gender, int date) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerImplement = new CustomerImplement(entityManager);
        Customer customer = new Customer(email, firstName, lastName, gender,date);
        customerImplement.save(customer);

        entityManager.close();
        entityManagerFactory.close();
    }

}
