
/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 2, 2023
 */
package model;

import javax.persistence.*;

@Entity
public class ListDetailsDriver {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private DriverIdentity driver;

    public ListDetailsDriver() {
        super();
    }

    public ListDetailsDriver(int id, DriverIdentity driver) {
        super();
        this.id = id;
        this.driver = driver;
    }

    public ListDetailsDriver(DriverIdentity driver) {
        super();
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DriverIdentity getDriver() {
        return driver;
    }

    public void setDriver(DriverIdentity driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "ListDetailsDriver [id=" + id + ", driver=" + driver + "]";
    }
}
