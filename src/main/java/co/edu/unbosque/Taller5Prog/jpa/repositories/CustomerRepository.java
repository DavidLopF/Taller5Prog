package co.edu.unbosque.Taller5Prog.jpa.repositories;

import co.edu.unbosque.Taller5Prog.jpa.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {


    void save(Customer customer);

    void update(String email, String first_name, String last_name, String gender, int age);

    void delete(String email);

    List<Customer> findAll();

    Optional<Customer> findById(String id);
}
