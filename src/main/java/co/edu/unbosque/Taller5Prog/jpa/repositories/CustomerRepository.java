package co.edu.unbosque.Taller5Prog.jpa.repositories;

public interface CustomerRepository {


    void save(String email, String first_name, String last_name, String gender, int age);

    void update(String email, String first_name, String last_name, String gender, int age);

    void delete(String email);
}
