
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
@Table(name = "Driver_Identity")
public class DriverIdentity {
    @Id
    @GeneratedValue
    private int id;
    private String driverFName;
    private String driverLName;

    public DriverIdentity() {
        super();
    }

    public DriverIdentity(int id, String driverFName, String driverLName) {
        super();
        this.id = id;
        this.driverFName = driverFName;
        this.driverLName = driverLName;
    }

    public DriverIdentity(String driverFName, String driverLName) {
        super();
        this.driverFName = driverFName;
        this.driverLName = driverLName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverFName() {
        return driverFName;
    }

    public void setDriverFName(String driverFName) {
        this.driverFName = driverFName;
    }

    public String getDriverLName() {
        return driverLName;
    }

    public void setDriverLName(String driverLName) {
        this.driverLName = driverLName;
    }

    @Override
    public String toString() {
        return "DriverIdentity [id=" + id + ", driverFName=" + driverFName + ", driverLName=" + driverLName + "]";
    }
}
