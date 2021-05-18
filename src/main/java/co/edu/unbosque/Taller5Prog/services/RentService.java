package co.edu.unbosque.Taller5Prog.services;

import co.edu.unbosque.Taller5Prog.jpa.entities.Customer;
import co.edu.unbosque.Taller5Prog.jpa.entities.Edition;
import co.edu.unbosque.Taller5Prog.jpa.entities.Rent;
import co.edu.unbosque.Taller5Prog.jpa.repositories.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.Optional;

public class RentService {

    EditionRepostoryImpl editionRepostory;
    RentRepositoryImpl rentRepository;
    CustomerRepository customerRepository;


    public void saveRent(String id_customer, int id_book, Date date) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerImplement(entityManager);
        rentRepository = new RentRepositoryImpl(entityManager);
        editionRepostory = new EditionRepostoryImpl(entityManager);

        Optional<Customer> customer = customerRepository.findById(id_customer);
        Edition edition = editionRepostory.findById(id_book);
        customer.ifPresent(temp -> {
            temp.addRent(new Rent(date), edition);
            customerRepository.save(temp);
        });


        entityManager.close();
        entityManagerFactory.close();
    }
}
