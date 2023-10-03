
/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 2, 2023
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Passenger_Identity")
public class PassengerIdentity {
    @Id
    @GeneratedValue
    private int id;
    private String passengerFName;
    private String passengerLName;

    public PassengerIdentity() {
        super();
    }

    public PassengerIdentity(int id, String passengerFName, String passengerLName) {
        super();
        this.id = id;
        this.passengerFName = passengerFName;
        this.passengerLName = passengerLName;
    }

    public PassengerIdentity(String passengerFName, String passengerLName) {
        super();
        this.passengerFName = passengerFName;
        this.passengerLName = passengerLName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassengerFName() {
        return passengerFName;
    }

    public void setPassengerFName(String passengerFName) {
        this.passengerFName = passengerFName;
    }

    public String getPassengerLName() {
        return passengerLName;
    }

    public void setPassengerLName(String passengerLName) {
        this.passengerLName = passengerLName;
    }

    @Override
    public String toString() {
        return "Passenger [id=" + id + ", passengerFName=" + passengerFName + ", passengerLName=" + passengerLName + "]";
    }
}
