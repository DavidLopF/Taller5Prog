package co.edu.unbosque.Taller5Prog.jpa.entities;

import javax.persistence.*;

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
    private String renting_date;

    @ManyToOne
    @JoinColumn(name = "edition_id")
    private Edition edition;

    public Rent() {

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

    public String getRenting_date() {
        return renting_date;
    }

    public void setRenting_date(String renting_date) {
        this.renting_date = renting_date;
    }
}
