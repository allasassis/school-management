package com.allas.api_school.model;

import com.allas.api_school.dto.student.DataUpdateAddress;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("addresses")
public class Address {

    private String street;
    private Integer number;
    private String city;
    private String state;
    private Integer zipCode;

    public Address() {
    }

    public Address(String street, Integer number, String city, String state, Integer zipCode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void update(DataUpdateAddress address) {
        if (address.getStreet() != null) {
            this.street = address.getStreet();
        }
        if (address.getNumber() != null) {
            this.number = address.getNumber();
        }
        if (address.getCity() != null) {
            this.city = address.getCity();
        }
        if (address.getState() != null) {
            this.state = address.getState();
        }
        if (address.getZipCode() != null) {
            this.zipCode = address.getZipCode();
        }
    }
}
