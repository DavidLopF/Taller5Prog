package co.edu.unbosque.Taller5Prog.services;

import co.edu.unbosque.Taller5Prog.jpa.entities.Customer;
import co.edu.unbosque.Taller5Prog.jpa.repositories.CustomerImplement;
import co.edu.unbosque.Taller5Prog.servlets.pojos.CustomerPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CustomerService {

    CustomerImplement customerImplement;

    public List<CustomerPOJO> listCustomers() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerImplement = new CustomerImplement(entityManager);
        List<Customer> customers = customerImplement.findAll();
        entityManager.close();
        entityManagerFactory.close();

        List<CustomerPOJO> customerPOJOS = new ArrayList<>();
        for (Customer customer : customers) {
            customerPOJOS.add(new CustomerPOJO(
                    customer.getEmail(),
                    customer.getFirst_name(),
                    customer.getLast_name(),
                    customer.getGender(),
                    customer.getAge()
            ));

        }
        return customerPOJOS;
    }

    public void saveCustomer(String email, String firstName, String lastName, String gender, int date) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerImplement = new CustomerImplement(entityManager);
        Customer customer = new Customer(email, firstName, lastName, gender, date);
        customerImplement.save(customer);

        entityManager.close();
        entityManagerFactory.close();
    }

}
