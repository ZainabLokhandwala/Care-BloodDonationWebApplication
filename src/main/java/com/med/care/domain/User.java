package com.med.care.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER)
public class User {

    protected String name;
    @Id
    @Column(name = "user_name")
    protected String userName;
    protected String password;
    protected int age;
    protected boolean sex;
    @Column(name = "blood_type")
    protected String bloodGroup;
    protected String allergies;
    protected String city;
    protected String country;
    protected byte[] image;
    @Column(name = "contact_information")
    protected String contactInformation;

    @OneToMany(mappedBy = "sender")
    protected List<Message> sentMessages = new ArrayList<Message>();
    @OneToMany(mappedBy = "receiver")
    protected List<Message> receivedMessages = new ArrayList<Message>();


    public User() {
    }

    public User(String name, String userName, String password, int age, boolean sex, String bloodGroup, String allergies, String city, String country, String contactInformation) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.city = city;
        this.country = country;
        this.contactInformation = contactInformation;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
}
