/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * CIS175 - Fall 2023
 * Sep 9, 2023
 */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cars")
public class ListItem {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    // New private variables
    @Column(name = "MAKE")
    private String make;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "CUSTOM_MODIFICATIONS")
    private String customModifications;

    public ListItem() {
        super();
    }
    
    public ListItem(String make, String model, String color, String customModifications) {
        super();
        this.make = make;
        this.model = model;
        this.color = color;
        this.customModifications = customModifications;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters and setters for new variables

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCustomModifications() {
        return customModifications;
    }

    public void setCustomModifications(String customModifications) {
        this.customModifications = customModifications;
    }
}