package com.med.care.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("0")
public class Donor extends User {

    @Column(name = "recent_medications")
    protected String recentMedications;

    public Donor() {
    }

    public String getRecentMedications() {
        return recentMedications;
    }


    public void setRecentMedications(String recentMedications) {
        this.recentMedications = recentMedications;
    }

    public Donor(String name, String userName, String password, int age, boolean sex, String bloodGroup, String allergies, String city, String country, String contactInformation, String recentMedications) {
        super(name, userName, password, age, sex, bloodGroup, allergies, city, country, contactInformation);
        this.recentMedications = recentMedications;
    }
}
