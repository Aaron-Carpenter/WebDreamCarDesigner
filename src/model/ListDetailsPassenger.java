
/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 2, 2023
 */
package model;

import javax.persistence.*;

@Entity
public class ListDetailsPassenger {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private PassengerIdentity passenger;

    public ListDetailsPassenger() {
        super();
    }

    public ListDetailsPassenger(int id, PassengerIdentity passenger) {
        super();
        this.id = id;
        this.passenger = passenger;
    }

    public ListDetailsPassenger(PassengerIdentity passenger) {
        super();
        this.passenger = passenger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PassengerIdentity getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerIdentity passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "ListDetailsPassenger [id=" + id + ", passenger=" + passenger + "]";
    }
}
