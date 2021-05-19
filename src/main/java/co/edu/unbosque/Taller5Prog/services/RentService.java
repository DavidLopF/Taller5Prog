package co.edu.unbosque.Taller5Prog.services;

import co.edu.unbosque.Taller5Prog.jpa.entities.Customer;
import co.edu.unbosque.Taller5Prog.jpa.entities.Edition;
import co.edu.unbosque.Taller5Prog.jpa.entities.Rent;
import co.edu.unbosque.Taller5Prog.jpa.repositories.*;
import co.edu.unbosque.Taller5Prog.servlets.pojos.RentPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RentService {

    EditionRepostoryImpl editionRepostory;
    RentRepositoryImpl rentRepository;
    CustomerRepository customerRepository;


    public void saveRent(String id_customer, int id_book, String date) {

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

    public List<RentPOJO> listRentsByCustomer(String email, String desde, String fin) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        rentRepository = new RentRepositoryImpl(entityManager);
        editionRepostory = new EditionRepostoryImpl(entityManager);

        String[] primera = desde.split("/");
        String[] segunda = fin.split("/");


        List<Rent> rents = rentRepository.findByCustomer(email);
        List<RentPOJO> rentPOJOList = new ArrayList<>();
        for (int i = 0; i < rents.size(); i++) {
            String[] fecha_renta = rents.get(i).getRenting_date().split("-");

            if (Integer.parseInt(primera[0]) <=  Integer.parseInt(fecha_renta[1])
                    && Integer.parseInt(primera[2]) <= Integer.parseInt(fecha_renta[0]) &
                    Integer.parseInt(segunda[0]) >= Integer.parseInt(fecha_renta[1])
                    && Integer.parseInt(segunda[2   ]) >= Integer.parseInt(fecha_renta[0])) {

                String descripcion = editionRepostory.findById(rents.get(i).getEdition().getEditionId()).getDescription();
                String libro = editionRepostory.findById(rents.get(i).getEdition().getEditionId()).getBook().getTitle();

                rentPOJOList.add(new RentPOJO(descripcion,
                        rents.get(i).getRenting_date()
                        , libro));
            }



        }



        return rentPOJOList;
    }
}
