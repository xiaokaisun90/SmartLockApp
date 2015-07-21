package com.example.simsim.entities;

/**
 * Created by xiaokaisun on 7/21/15.
 */
public class Properties {
    private int propertyId;
    private String description;
    private String address;
    private int zipCode;
    private String city;
    private String state;
    private String country;
    private int userId;
    private String ownship;//privacy or public
    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOwnship() {
        return ownship;
    }

    public void setOwnship(String ownship) {
        this.ownship = ownship;
    }



}
