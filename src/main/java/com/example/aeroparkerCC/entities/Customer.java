package com.example.aeroparkerCC.entities;

import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Customer {
    private int id;
    private Date registered;
    private String email_address;
    private String title;
    private String first_name;
    private String last_name;
    private String address_line_1;
    private String address_line_2;
    private String city;
    private String postcode;
    private String phone_number;

    public int getCustomerID() {
        return id;
    }

    public void setCustomerID(int id) {
        this.id = id;
    }

    public Date getRegistered() {
        return registered;
    }

    public String getRegisteredAsString(){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sf.format(registered);
        return dateString;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }

    public String getAddress_line_2() {
        return address_line_2;
    }

    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
