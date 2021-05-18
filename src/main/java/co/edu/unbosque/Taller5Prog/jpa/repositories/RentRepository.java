package co.edu.unbosque.Taller5Prog.jpa.repositories;

import co.edu.unbosque.Taller5Prog.jpa.entities.Rent;

import java.util.Optional;

public interface RentRepository {

    Optional<Rent> save(Rent rent);


}
