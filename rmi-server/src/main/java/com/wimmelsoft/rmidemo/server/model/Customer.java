package com.wimmelsoft.rmidemo.server.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "CUST_SEQ", initialValue = 1_000_001)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    private long id;
    private String firstName;
    private String lastName;
    private String socialSecurityCode;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String socialSecurityCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityCode = socialSecurityCode;
    }


    public long getId() {
        return id;
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

    public String getSocialSecurityCode() {
        return socialSecurityCode;
    }

    public void setSocialSecurityCode(String socialSecurityCode) {
        this.socialSecurityCode = socialSecurityCode;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", socialSecurityCode='").append(socialSecurityCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
