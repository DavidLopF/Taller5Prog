package co.edu.unbosque.Taller5Prog.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "customers") // Optional
@NamedQueries({
        @NamedQuery(name = "Customer.findAll",
                query = "SELECT b FROM Edition b")
})
public class Customer {
}
