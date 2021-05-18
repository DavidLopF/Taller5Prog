package co.edu.unbosque.Taller5Prog.jpa.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rents") // Optional
@NamedQueries({
        @NamedQuery(name = "Rent.findAll",
                query = "SELECT b FROM Edition b")
})
public class Rent {

    @Id
    @GeneratedValue
    @Column(name = "rent_id")
    private int rent_id;

    @ManyToOne
    @JoinColumn(name = "email")
    private Customer customer;

    @Column(name = "renting_date")
    private Date renting_date;

    @ManyToOne
    @JoinColumn(name = "edition_id")
    private Edition edition;


    public Rent() {

    }

    public Rent(Date fecha) {
        this.renting_date = fecha;
    }

    public int getRent_id() {
        return rent_id;
    }

    public void setRent_id(int rent_id) {
        this.rent_id = rent_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getRenting_date() {
        return renting_date;
    }

    public void setRenting_date(Date renting_date) {
        this.renting_date = renting_date;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }
}
