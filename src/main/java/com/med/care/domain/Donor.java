package com.med.care.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("0")
public class Donor extends User {

    protected String recentMedications;

    public String getRecentMedications() {
        return recentMedications;
    }

    public void setRecentMedications(String recentMedications) {
        this.recentMedications = recentMedications;
    }
}
