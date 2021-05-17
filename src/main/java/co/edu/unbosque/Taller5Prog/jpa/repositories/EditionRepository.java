package co.edu.unbosque.Taller5Prog.jpa.repositories;

import co.edu.unbosque.Taller5Prog.jpa.entities.Edition;

import java.util.List;
import java.util.Optional;

public interface EditionRepository {

    Optional<Edition> save(Edition editon);

    List<Edition> findAll();
}
