package org.entity;

import jakarta.persistence.*;

@Entity
@Table(name="userCards")
public class UserCardEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name = "";
    private String address = "";
    private String city = "";
    private String state = "";
    private String email = "";
    private String phone = "";
    private String imgLink = "";

    // Constructors
    public UserCardEntity(long id, String name, String address, String city, String state, String email, String phone, String imgLink) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.phone = phone;
        this.imgLink = imgLink;
    }

    public UserCardEntity() {
    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

}
