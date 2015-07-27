package com.med.care.domain;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("1")
public class Receiver extends User {

    @Column(name = "quantity_needed")
    protected int quantityNeeded;
    @Column(name = "date_needed")
    protected Date dateNeeded;

    public Receiver() {
    }

    public Receiver(String name, String userName, String password, int age, boolean sex, String bloodGroup, String allergies, String city, String country, String contactInformation, Date dateNeeded, int quantityNeeded) {
        super(name, userName, password, age, sex, bloodGroup, allergies, city, country, contactInformation);
        this.dateNeeded = dateNeeded;
        this.quantityNeeded = quantityNeeded;
    }

    public int getQuantityNeeded() {
        return quantityNeeded;
    }

    public void setQuantityNeeded(int quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }

    public Date getDateNeeded() {
        return dateNeeded;
    }

    public void setDateNeeded(Date dateNeeded) {
        this.dateNeeded = dateNeeded;
    }
}
