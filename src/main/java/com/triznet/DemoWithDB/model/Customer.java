package com.triznet.DemoWithDB.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", length = 255)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "customer_nr")
    private String customerNr;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerNr() {
        return customerNr;
    }

    public void setCustomerNr(String clientNr) {
        this.customerNr = clientNr;
    }
}
